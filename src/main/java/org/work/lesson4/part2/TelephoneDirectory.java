package org.work.lesson4.part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TelephoneDirectory {
    private Map<String, List<User>> directory;

    public TelephoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(User user) {
        directory.computeIfAbsent(user.getSurname(), listBayKey -> new ArrayList<>()).add(user);
    }

    public void add(List<User> users) {
        for (User user : users) {
            directory.computeIfAbsent(user.getSurname(), listBayKey -> new ArrayList<>()).add(user);
        }
    }

    public List<User> getNumbers(String surname) {
        return directory.get(surname);
    }
}
