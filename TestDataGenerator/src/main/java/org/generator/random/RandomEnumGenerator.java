package org.generator.random;

import java.util.Random;

public class RandomEnumGenerator <T extends Enum<T>>{

    private static final Random RAND = new Random();
    private final T[] values;

    public RandomEnumGenerator(Class<T> e) {
        values = e.getEnumConstants();
    }

    public T randomEnum() {
        return values[RAND.nextInt(values.length)];
    }
}
