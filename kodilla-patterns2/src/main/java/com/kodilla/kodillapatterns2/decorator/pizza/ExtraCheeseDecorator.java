package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheeseDecorator extends AbstractPizzaOrderDecorator {
    public ExtraCheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2.5));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + extra cheese";
    }
}
