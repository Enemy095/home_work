package org.work.lesson7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleStateException;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.OptimisticLockException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        addRow();
        addItemWithFixedOperations();
        sum();
    }

    public static void addItemWithFixedOperations() {
        final int THREAD_COUNT = 8;
        final int OPERATIONS_PER_THREAD = 20;  // Каждый поток делает 20 операций
        final int MAX_RETRIES = 3;
        final int ITEM_ID_RANGE = 40;
        final int BASE_DELAY_MS = 50;
        final int OPERATION_DELAY_MS = 500;

        // Статистика выполнения
        final AtomicInteger totalSuccess = new AtomicInteger();
        final AtomicInteger totalFailures = new AtomicInteger();

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class)
                .buildSessionFactory()) {

            final CountDownLatch completionLatch = new CountDownLatch(THREAD_COUNT);
            final ThreadLocal<Random> threadRandom = ThreadLocal.withInitial(Random::new);

            for (int i = 0; i < THREAD_COUNT; i++) {
                final int threadNum = i + 1;
                new Thread(() -> {
                    int successCount = 0;
                    try {
                        for (int opCount = 0; opCount < OPERATIONS_PER_THREAD; opCount++) {
                            boolean success = processSingleOperation(
                                    sessionFactory,
                                    threadNum,
                                    threadRandom.get(),
                                    ITEM_ID_RANGE,
                                    MAX_RETRIES,
                                    OPERATION_DELAY_MS,
                                    BASE_DELAY_MS,
                                    opCount + 1
                            );
                            if (success) successCount++;
                        }
                    } finally {
                        totalSuccess.addAndGet(successCount);
                        totalFailures.addAndGet(OPERATIONS_PER_THREAD - successCount);
                        completionLatch.countDown();
                    }
                }).start();
            }

            completionLatch.await();
            System.out.printf("\nFinal results: Success: %d, Failures: %d, Total: %d\n",
                    totalSuccess.get(), totalFailures.get(),
                    totalSuccess.get() + totalFailures.get());

        } catch (Exception e) {
            System.err.println("System error: " + e.getMessage());
        }
    }

    private static boolean processSingleOperation(SessionFactory sessionFactory,
                                                  int threadNum,
                                                  Random random,
                                                  int itemRange,
                                                  int maxRetries,
                                                  int operationDelay,
                                                  int baseDelay,
                                                  int operationNumber) {
        String threadName = String.format("Worker-%02d", threadNum);
        Long itemId = random.nextLong(1, itemRange + 1);

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try (Session session = sessionFactory.openSession()) {
                if (tryUpdateItem(session, itemId, operationDelay, threadName, attempt, operationNumber)) {
                    return true;
                }
            } catch (Exception e) {
                handleOperationError(threadName, itemId, attempt, maxRetries, e, baseDelay, operationNumber);
            }
        }
        System.out.printf("%s: Operation %02d FAILED after %d attempts\n",
                threadName, operationNumber, maxRetries);
        return false;
    }

    private static boolean tryUpdateItem(Session session,
                                         Long itemId,
                                         int delay,
                                         String threadName,
                                         int attempt,
                                         int operationNumber) throws Exception {
        Transaction tx = session.beginTransaction();
        try {
            Item item = session.get(Item.class, itemId);
            if (item == null) {
                tx.commit();
                System.out.printf("%s: [Op %02d] Item %d not found\n",
                        threadName, operationNumber, itemId);
                return false;
            }

            int oldValue = item.getValue();
            item.setValue(oldValue + 1);
            sleepSafe(delay);

            session.update(item);
            tx.commit();

            System.out.printf("%s: [Op %02d] Updated item %d: %d→%d (attempt %d)\n",
                    threadName, operationNumber, itemId, oldValue, oldValue + 1, attempt);
            return true;

        } catch (OptimisticLockException | StaleStateException e) {
            tx.rollback();
            throw e;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    private static void handleOperationError(String threadName,
                                             Long itemId,
                                             int attempt,
                                             int maxRetries,
                                             Exception e,
                                             int baseDelay,
                                             int operationNumber) {
        if (e instanceof OptimisticLockException || e instanceof StaleStateException) {
            if (attempt < maxRetries) {
                System.out.printf("%s: [Op %02d] Conflict on item %d (attempt %d/%d)\n",
                        threadName, operationNumber, itemId, attempt, maxRetries);
                sleepSafe(baseDelay * attempt);
            }
        } else {
            System.err.printf("%s: [Op %02d] Error: %s\n",
                    threadName, operationNumber, e.getMessage());
        }
    }

    private static void sleepSafe(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    private static void sum() {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class)
                .buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Long sum = (Long) session.createQuery("SELECT SUM(i.value) FROM Item i")
                        .uniqueResult();

                System.out.println("Total sum: " + (sum != null ? sum : 0));

            } catch (Exception e) {
                System.err.println("Error calculating sum: " + e.getMessage());
                e.printStackTrace();
            } finally {
                if (sessionFactory != null) {
                    sessionFactory.close();
                }
            }
        }
    }

    public static void addRow() {
        final int BATCH_SIZE = 40;

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            for (int i = 1; i <= 40; i++) {
                Item item1 = new Item();
                item1.setValue(0);
                session.persist(item1);
                if (i % BATCH_SIZE == 0) {
                    session.flush();
                    session.clear();
                }
            }
            session.getTransaction().commit();
        } catch (OptimisticLockException e) {
            session.getTransaction().rollback();
        }
        session.close();
        sessionFactory.close();
    }
}