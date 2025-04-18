package org.work.lesson2;

public class Cat implements Creature {
    private String name;
    private int maxJumpHeight;
    private int maxRunDistance;
    private boolean success;

    public Cat(String name, int maxJumpHeight, int maxRunDistance) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
        this.success = true;
    }

    public void jump(int height) {
        if (this.maxJumpHeight > height) {
            System.out.println("Кот " + this.name + " успешно перепрыгнул");
        } else {
            System.out.println("Кот " + this.name + " не смог перепрыгнуть");
            this.success = false;
        }

    }

    public void run(int length) {
        if (this.maxRunDistance > length) {
            System.out.println("Кот " + this.name + " успешно пробежал");
        } else {
            System.out.println("Кот " + this.name + " не смог пробежать");
            this.success = false;
        }

    }

    public boolean isSuccess() {
        return this.success;
    }
}
