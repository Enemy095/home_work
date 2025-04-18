package org.work.lesson2;

public class Wall implements Exercise {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void performExercise(Creature creature) {
        creature.jump(this.height);
    }
}
