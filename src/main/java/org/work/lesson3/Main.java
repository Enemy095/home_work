package org.work.lesson3;

import org.work.lesson3.part3.Box;
import org.work.lesson3.part3.fruit.Apple;
import org.work.lesson3.part3.fruit.Orange;
import org.work.lesson3.part_1_2.Editor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //testPart1And2();

        testPart3();
    }

    private static void testPart1And2() {
        System.out.println("part1:");;
        List<String> words = new ArrayList<>(List.of("A", "B", "C", "D", "E", "F"));
        Editor.changeTheElementsInPlaces(words);
        System.out.println("""


                part2:""");
        String[] strings = {
                "f",
                "s",
                "g"
        };

        Integer[] integers = {
                1,
                3,
                5,
                7
        };
        System.out.println(Editor.convertInArrayList(strings));
        System.out.println(Editor.convertInArrayList(integers));
    }

    private static void testPart3() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        List<Apple> apples2 = new ArrayList<>();
        apples2.add(new Apple());
        apples2.add(new Apple());

        List<Orange> oranges = new ArrayList<>();
        oranges.add(new Orange());

        Box<Orange> box3 = new Box<>(oranges, 12);
        Box<Apple> box1 = new Box<>(apples, 55);
        Box<Apple> box2 = new Box<>(apples2, 22);

        box1.pourIntoAnotherBox(box2);
        System.out.println(box3.getWeight());
        System.out.println(box1.compare(box3));
        box3.addFruit(new Orange());

    }
}
