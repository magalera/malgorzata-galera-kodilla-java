package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class MushroomsDecorator extends AbstractPizzaOrderDecorator {
    public MushroomsDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3.5));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", mushrooms";
    }
}
