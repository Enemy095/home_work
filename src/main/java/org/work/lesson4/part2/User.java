package org.work.lesson4.part2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String surname;
    private String number;

    public User(String surname, String number) {
        this.surname = surname;
        this.number = number;
    }

    @Override
    public String toString() {
        return surname + ": " + number;
    }
}
