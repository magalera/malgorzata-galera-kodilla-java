package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    public static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .forEach(value -> System.out.println(numbers[value]));
        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average().getAsDouble();
    }
}
