package org.work.lesson2;

public class Treadmill implements Exercise {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public void performExercise(Creature creature) {
        creature.run(this.length);
    }
}

