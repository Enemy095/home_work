package org.work.lesson1;

import java.util.Scanner;

public class TasksForAnimals {
    private static final Scanner scanner = new Scanner(System.in);

    public static void animalsSwim(Animal[] animals){
        int distanceInMeters = TasksForAnimals.EnterTheValue();
        System.out.println("Расстояние для заплыва: " + distanceInMeters);
        for (Animal animal : animals) {
            animal.swim(distanceInMeters);
        }
    }

    public static void animalsRun(Animal[] animals){
        int distanceInMeters = TasksForAnimals.EnterTheValue();
        System.out.println("Расстояние для забега: " + distanceInMeters);
        for (Animal animal : animals) {
            animal.run(distanceInMeters);
        }
    }

    private static int EnterTheValue(){
        int distanceInMeters;
        do {
            System.out.println("Введите положительное расстояние: ");
            distanceInMeters = scanner.nextInt();
        } while (distanceInMeters < 0);
        return distanceInMeters;
    }
}
