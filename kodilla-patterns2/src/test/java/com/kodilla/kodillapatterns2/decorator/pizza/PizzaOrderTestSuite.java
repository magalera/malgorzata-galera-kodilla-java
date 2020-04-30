package com.kodilla.kodillapatterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals("Cake, tomato sauce, cheese", ingredients);
    }

    @Test
    public void testPizzaOrderWithHamGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(19), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithHamGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);

        //When
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals("Cake, tomato sauce, cheese, ham", ingredients);
    }

    @Test
    public void testPizzaOrderWithHamAndMushroomsGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(22.5), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithHamAndMushroomsGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        //When
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals("Cake, tomato sauce, cheese, ham, mushrooms", ingredients);
    }

    @Test
    public void testPizzaOrderWithHamAndExtraCheeseGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(21.5), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithHamAndExtraCheeseGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);

        //When
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals("Cake, tomato sauce, cheese, ham + extra cheese", ingredients);
    }
}
