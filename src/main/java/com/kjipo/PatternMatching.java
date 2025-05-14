package com.kjipo;

import java.time.ZonedDateTime;
import java.util.UUID;


/**
 * <a href="https://openjdk.org/jeps/441">JEP 441: Pattern Matching for switch</a>
 */
public final class PatternMatching {


    private PatternMatching() {
        // Empty constructor
    }


    private static void patternMatching() {
        var dataRecord = new DataRecord(UUID.randomUUID(), "Test", 1, ZonedDateTime.now());

        switch (dataRecord.data()) {
            case "Test" -> System.out.println("Test");
            case String s
                    when s.equalsIgnoreCase("Data") -> System.out.println("Data");
            case String s
                    when (s.isEmpty()) -> System.out.println("Empty string");
            case String _ -> System.out.println("No match");
            case null -> System.out.println("No data given");
        }

    }


    public static void main(String[] args) {
        patternMatching();
    }


}
