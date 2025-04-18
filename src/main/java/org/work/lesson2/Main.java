package org.work.lesson2;

public class Main {
    public static void main(String[] args) {
        Creature[] creatures = {
                new Cat("Барсик", 2, 150),
                new Human("Боб", 3, 500),
                new Robot("Валли", 4, 10000)
        };
        Exercise[] exercises = {
                new Treadmill(50),
                new Wall(2),
                new Wall(1),
                new Wall(3),
                new Treadmill(300),
                new Wall(2),
                new Treadmill(250)
        };
        Competition.competition(creatures, exercises);
    }
}