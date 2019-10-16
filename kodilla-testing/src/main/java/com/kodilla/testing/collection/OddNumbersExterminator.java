package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public static ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            int rest = number % 2;
            if (rest == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }
}
