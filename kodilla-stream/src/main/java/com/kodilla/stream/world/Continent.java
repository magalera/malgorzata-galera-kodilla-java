package com.kodilla.stream.world;

import java.util.List;

public final class Continent {

    private final String name;
    private final List<Country> countriesList;

    public Continent(final String name, final List<Country> countriesList) {
        this.name = name;
        this.countriesList = countriesList;
    }

    public String getName() {
        return name;
    }

    public List<Country> getCountriesList() {
        return countriesList;
    }
}
