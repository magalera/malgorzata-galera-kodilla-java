package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CollectionTestSuit {
    @Before
    public void before() {
        System.out.println("Execauting test: ");
    }

    @After
    public void after() {
        System.out.println("Finished.");
    }

    @Test
    //(sprawdzi, czy klasa zachowuje się poprawnie, gdy lista jest pusta)
    public void testOddNumbersExterminatorEmptyList() {
        // given
        ArrayList<Integer> allNumbers = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();

        // when
        ArrayList<Integer> result = OddNumbersExterminator.exterminate(allNumbers);

        // then
        Assert.assertEquals(expected, result);
        System.out.println("Testing empty list.");

    }

    @Test
    //(sprawdzi, czy klasa zachowuje się poprawnie, gdy lista zawiera liczby parzyste i nieparzyste)
    public void testOddNumbersExterminatorNormalList() {
        // given
        ArrayList<Integer> allNumbers = new ArrayList<>();
        allNumbers.add(1);
        allNumbers.add(2);
        allNumbers.add(3);
        allNumbers.add(4);
        allNumbers.add(5);
        allNumbers.add(6);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(6);

        // when
        ArrayList<Integer> result = OddNumbersExterminator.exterminate(allNumbers);

        // then
        Assert.assertEquals(expected, result);
        System.out.println("Testing full list.");
    }
}
