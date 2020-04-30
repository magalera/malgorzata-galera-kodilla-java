package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(15);
    }

    @Override
    public String getIngredients() {
        return "Cake, tomato sauce, cheese";
    }
}
