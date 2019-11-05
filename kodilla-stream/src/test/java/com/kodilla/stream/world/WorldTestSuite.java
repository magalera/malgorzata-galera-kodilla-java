package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public final class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country poland = new Country("Poland", new BigDecimal("100"));
        Country spanish = new Country("Spanish", new BigDecimal("120"));
        ArrayList<Country> europeCountries = new ArrayList<>();
        europeCountries.add(poland);
        europeCountries.add(spanish);

        Country egypt = new Country("Egypt", new BigDecimal("200"));
        ArrayList<Country> africaCountries = new ArrayList<>();
        africaCountries.add(egypt);

        ArrayList<Continent> continents = new ArrayList<>();
        continents.add(new Continent("Europe", europeCountries));
        continents.add(new Continent("Africa", africaCountries));

        World world = new World(continents);

        //When
        BigDecimal actual = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(poland.getPeopleQuantity().add(spanish.getPeopleQuantity().add(egypt.getPeopleQuantity())), actual);
    }
}
