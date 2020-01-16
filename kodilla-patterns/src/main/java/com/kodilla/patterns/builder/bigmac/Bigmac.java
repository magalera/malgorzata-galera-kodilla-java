package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Bigmac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    private Bigmac(final String bun, final int burgers, final String sauce, final List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            List<String> allowedBun = Arrays.asList("sesame", "without sesame");
            if (allowedBun.contains(bun)) {
                this.bun = bun;
            } else {
                throw new IllegalStateException("Bun " + bun + " is unallowed. Please select 'sesame' or 'without sesame.");
            }
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers < 1 || burgers > 4) {
                throw new IllegalStateException("Portion " + burgers + " of beef is unallowed. Please select from 1 to 4.");
            }
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            List<String> allowedSauce = Arrays.asList("standard", "1000 islands", "barbecue");
            if (allowedSauce.contains(sauce)) {
                this.sauce = sauce;
            } else {
                throw new IllegalStateException("Sauce " + sauce + " is absent from the list. Please select from available.");
            }
            return this;
        }

        public BigmacBuilder ingredients(String ingredient) {
            List<String> allowedIngredients = Arrays.asList("lettuce", "onion", "bacon", "cucumber", "chilli peppers", "mushrooms", "shrimps", "cheese");
            if (allowedIngredients.contains(ingredient)) {
                ingredients.add(ingredient);
            } else {
                throw new IllegalStateException("Ingredient " + ingredient + " is absent from the list. Please select from available.");
            }
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bigmac bigmac = (Bigmac) o;
        return getBurgers() == bigmac.getBurgers() &&
                getBun().equals(bigmac.getBun()) &&
                getSauce().equals(bigmac.getSauce()) &&
                getIngredients().equals(bigmac.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBun(), getBurgers(), getSauce(), getIngredients());
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers='" + burgers + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
