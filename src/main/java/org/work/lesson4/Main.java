package org.work.lesson4;

import org.work.lesson4.part1.Array;
import org.work.lesson4.part2.TelephoneDirectory;
import org.work.lesson4.part2.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testPart1();
        testPart2();
    }

    public static void testPart1() {
        List<String> list = new ArrayList<>(Arrays.asList("Море", "Дождь",
                "Костер", "Кофе", "Дождь", "Океан", "Океан", "Весна", "Ночь"));

        System.out.println(Array.bringOutUniqueElements(list));
    }

    public static void testPart2() {
        User user = new User("Жуков", "8(800)555-35-35");
        User user1 = new User("Жуков", "8(800)555-00-35");
        User user2 = new User("Сталин", "8(800)555-35-00");
        User user3 = new User("Паравозов", "8(800)555-00-00");

        List<User> listUser = new ArrayList<>(Arrays.asList(user2, user3));

        TelephoneDirectory russianTelephoneDirectory = new TelephoneDirectory();
        russianTelephoneDirectory.add(user);
        russianTelephoneDirectory.add(user1);
        russianTelephoneDirectory.add(listUser);
        System.out.println(russianTelephoneDirectory.getNumbers("Жуков"));
    }
}
