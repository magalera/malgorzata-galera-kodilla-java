package com.kodilla.good.patterns.challenges;

public class Game implements Product {

    private String name;
    private Double prize;

    public Game(String name, Double prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public Double getPrize() {
        return prize;
    }
}
