package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        
        //Given
        double sum = 0;
        int[] numbers = new int[20];

        numbers[0] = 1;
        numbers[1] = 3;
        numbers[2] = 2;
        numbers[3] = 13;
        numbers[4] = 7;
        numbers[5] = 34;
        numbers[6] = 17;
        numbers[7] = 23;
        numbers[8] = 4;
        numbers[9] = 18;
        numbers[10] = 33;
        numbers[11] = 29;
        numbers[12] = 11;
        numbers[13] = 78;
        numbers[14] = 6;
        numbers[15] = 15;
        numbers[16] = 9;
        numbers[17] = 19;
        numbers[18] = 124;
        numbers[19] = 25;

        for (int number : numbers) {
            sum = sum + number;
        }

        //When
        double average = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(sum / numbers.length, average, 0.01);
        System.out.println(average);
    }
}

