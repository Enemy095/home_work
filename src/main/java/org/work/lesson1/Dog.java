package org.work.lesson1;

public class Dog extends Animal {
    private static int count = 0;

    public Dog(String name) {
        super(name);
        count = count + 1;
    }

    public static void infoCount() {
        System.out.println(count + " собак");
    }

    @Override
    public void run(int distance) {
        if (distance > 1000) {
            System.out.println("Собака " + name + " не смогла пробежать " + distance + " метров");
        } else {
            System.out.println("Собака " + name + " пробежала " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Собака " + name + " не смогла проплыть " + distance + " метров");
        } else {
            System.out.println("Собака " + name + " проплыла " + distance + " метров");
        }
    }
}
