package org.work.lesson3.part_1_2;

import java.util.*;

public class Editor {
    private static final Scanner scanner = new Scanner(System.in);

    public static <E> void changeTheElementsInPlaces(List<E> words) {
        System.out.println(words);
        System.out.printf("""
                Размер массива: %d
                Введите индексы, которые нужно поменять местами""", words.size());
        int first;
        int second;
        do {
            first = scanner.nextInt();
            second = scanner.nextInt();
        } while (first > words.size() || second > words.size());
        System.out.println();
        E string1;
        E string2;
        string1 = words.get(first);
        string2 = words.get(second);
        words.set(first, string2);
        words.set(second, string1);
        System.out.println(words);
    }

    public static <T> ArrayList<T> convertInArrayList(T[] editor) {
        return new ArrayList<>(Arrays.asList(editor));
    }
}
