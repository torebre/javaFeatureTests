package com.kjipo;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

public class ComparatorTesting {

    private record User(String firstName, String lastLame,

                        LocalDate birthDate) {

    }

    private static final Random random = new Random();


    private static void runComparison() {
        ArrayList<User> users = new ArrayList<>(10);

        IntStream.range(0, 10).forEach(value -> {
            Year birthYear = Year.now().minusYears(random.nextLong(10, 60));
            Month month = Month.values()[random.nextInt(0, Month.values().length)];
            var day = random.nextInt(1, month.length(birthYear.isLeap()) + 1);

            users.add(new User("Test" + value, "Tester", LocalDate.of(birthYear.getValue(), month.getValue(), day)));
        });
        users.sort(Comparator.comparing(User::birthDate).reversed());

        users.forEach(System.out::println);
    }


    public static void main(String[] args) {
        runComparison();
    }

}
