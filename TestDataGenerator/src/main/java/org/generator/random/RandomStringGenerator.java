package org.generator.random;

import java.util.Random;

public class RandomStringGenerator {

    public static String randomNumeric(int length) {
        return randomUsingStreams(length, '0', '9');
    }

    public static String randomString(int length) {
        return randomUsingStreams(length, 'a', 'z');
    }

    public static String randomAlphaNumeric(int length) {
        return randomUsingStreams(length, '1', 'z');
    }

    private static String randomUsingStreams(int length, int start, int end) {

        Random random = new Random();

        return random.ints(start, end + 1)
                .filter(i -> Character.isLetter(i) || Character.isDigit(i))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
