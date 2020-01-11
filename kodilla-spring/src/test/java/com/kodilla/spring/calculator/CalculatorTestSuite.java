package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculationAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator) context.getBean("calculator");

        //When
        Double actual = calculator.add(2.0, 4.0);

        //Then
        Assert.assertEquals(Double.valueOf(6.0), actual);
    }

    @Test
    public void testCalculationSub() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator) context.getBean("calculator");

        //When
        Double actual = calculator.sub(2.0, 4.0);

        //Then
        Assert.assertEquals(Double.valueOf(-2.0), actual);
    }

    @Test
    public void testCalculationMul() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator) context.getBean("calculator");

        //When
        Double actual = calculator.mul(5.0, 4.0);

        //Then
        Assert.assertEquals(Double.valueOf(20.0), actual);
    }

    @Test
    public void testCalculationDiv() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator) context.getBean("calculator");

        //When
        Double actual = calculator.div(25.0, 2.0);

        //Then
        Assert.assertEquals(Double.valueOf(12.5), actual);
    }

}