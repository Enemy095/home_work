package org.work.lesson1;

public class Tiger extends Animal {
    private static int count = 0;

    public Tiger(String name) {
        super(name);
        count = count + 1;
    }

    public static void infoCount() {
        System.out.println(count + " тигров");
    }

    @Override
    public void run(int distance) {
        if (distance > 1500) {
            System.out.println("Тигр " + name + " не смог пробежать " + distance + " метров");
        } else {
            System.out.println("Тигр " + name + " пробежал " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 1500) {
            System.out.println("Тигр " + name + " не смог проплыть " + distance + " метров");
        } else {
            System.out.println("Тигр " + name + " проплыл " + distance + " метров");
        }
    }
}
