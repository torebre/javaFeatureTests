package com.kjipo;


import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

public final class MarkdownExample {


    /// Creates a random string. Example of **bold** text.
    ///
    /// @return a random string
    /// @implSpec Example of an implementation specification.
    /// @see java.lang.String
    public String createRandomString() {
        RandomGenerator randomGenerator = new Random();
        StringBuilder stringBuilder = new StringBuilder(64);
        int codePoint;

        do {
            codePoint = randomGenerator.nextInt(0x10000);
            if (!Character.isSurrogate((char) codePoint) &&
                    Character.isDefined(codePoint)) {
                stringBuilder.append((char) codePoint);
            }
        } while (stringBuilder.length() < 64);

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        var markdownExample = new MarkdownExample();
        System.out.println(markdownExample.createRandomString());
    }


}
