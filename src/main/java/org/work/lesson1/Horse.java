package org.work.lesson1;

public class Horse extends Animal {
    private static int count = 0;

    public Horse(String name) {
        super(name);
        count = count + 1;
    }

    public static void infoCount() {
        System.out.println(count + " лошадей");
    }

    @Override
    public void run(int distance) {
        if (distance > 10000) {
            System.out.println("Лошадь " + name + " не смогла пробежать " + distance + " метров");
        } else {
            System.out.println("Лошадь " + name + " пробежала " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 100) {
            System.out.println("Лошадь " + name + " не смогла проплыть " + distance + " метров");
        } else {
            System.out.println("Лошадь " + name + " проплыла " + distance + " метров");
        }
    }
}
