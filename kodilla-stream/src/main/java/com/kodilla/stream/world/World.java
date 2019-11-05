package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class World {

    private final List<Continent> continentsList;

    public World(final List<Continent> continentsList) {
        this.continentsList = continentsList;
    }

    public List<Continent> getContinentsList() {
        return continentsList;
    }

    public BigDecimal getPeopleQuantity(){
        return continentsList.stream()
                .flatMap(continent -> continent.getCountriesList().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current));


    }
}

