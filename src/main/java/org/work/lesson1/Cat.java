package org.work.lesson1;

public class Cat extends Animal {
    private static int count = 0;

    public Cat(String name) {
        super(name);
        count = count + 1;
    }

    public static void infoCount() {
        System.out.println(count + " котов");
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Кот " + name + " не смог пробежать " + distance + " метров");
        } else {
            System.out.println("Кот " + name + " пробежал " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать");
    }
}
