package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BigmacTestSuite {

    @Test
    public void testBigMacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesame")
                .burgers(3)
                .sauce("standard")
                .ingredients("onion")
                .ingredients("bacon")
                .ingredients("cheese")
                .build();
        System.out.println(bigmac);

        //When
        String actualBun = bigmac.getBun();
        int actualBurgers = bigmac.getBurgers();
        String actualSauce = bigmac.getSauce();
        List<String> actualIngredients = bigmac.getIngredients();

        //Then
        Assert.assertEquals("sesame", actualBun);
        Assert.assertEquals(3, actualBurgers);
        Assert.assertEquals("standard", actualSauce);
        Assert.assertTrue(actualIngredients.contains("onion"));
        Assert.assertTrue(actualIngredients.contains("bacon"));
        Assert.assertTrue(actualIngredients.contains("cheese"));
        Assert.assertFalse(actualIngredients.contains("lettuce"));
        Assert.assertEquals(3, actualIngredients.size());
    }
}