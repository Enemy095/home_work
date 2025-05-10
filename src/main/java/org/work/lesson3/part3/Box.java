package org.work.lesson3.part3;

import lombok.Getter;
import org.work.lesson3.part3.fruit.Fruits;

import java.util.List;

@Getter
public class Box<T extends Fruits> {
    private List<T> fruits;
    private int quantity;
    private double weight;

    public Box(List<T> fruits, int quantity) {
        this.fruits = fruits;
        this.quantity = quantity;
        weight = getWeight(fruits.get(0));
    }

    public double getWeight(T fruit) {
        weight = fruits.size() * fruit.getWeight();
        return weight;
    }

    public boolean compare(Box<?> box) {
        return weight == box.weight;
    }

    public void pourIntoAnotherBox(Box<T> box) {
        box.fruits.addAll(this.fruits);
        this.fruits.clear();
        System.out.println("Фрукты пересыпаны");
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
        System.out.println("Фрукт добавлен");
    }
}
