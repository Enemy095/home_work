package org.work.lesson1;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Барсик"),
                new Cat("Рыжик"),
                new Dog("Шарик"),
                new Horse("Ветер"),
                new Tiger("Пушистик")
        };

        TasksForAnimals.animalsRun(animals);
        TasksForAnimals.animalsSwim(animals);

        Cat.infoCount();
        Dog.infoCount();
        Horse.infoCount();
        Tiger.infoCount();
        Animal.infoCount();
    }
}