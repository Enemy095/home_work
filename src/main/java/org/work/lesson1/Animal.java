package org.work.lesson1;

public abstract class Animal {
    String name;
    private static int countAnimals = 0;

    public Animal(String name) {
        this.name = name;
        countAnimals = countAnimals + 1;
    }

    public static void infoCount() {
        System.out.println(countAnimals + " животных всего");
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}

