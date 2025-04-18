package org.work.lesson2;

public class Competition {
    public static void competition(Creature[] creatures, Exercise[] exercises){
        for (Creature creature : creatures) {
            for (Exercise exercise : exercises) {
                exercise.performExercise(creature);
                if (!creature.isSuccess()) {
                    break;
                }
            }
        }
    }
}
