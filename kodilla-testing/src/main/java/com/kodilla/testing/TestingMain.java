package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser user = new SimpleUser("Tom");

        String isTheSameUser = user.getUsername();
        if (isTheSameUser.equals("Tom")) {
            System.out.println("Test ok");
        } else {
            System.out.println("Error");
        }

        // next test - Class Calculator/testing add() and substract();
        Calculator calculator = new Calculator();
        int resultAdd1 = calculator.add(7, 4);
        int resultAdd2 = calculator.add(13, 47);
        int resultAdd3 = calculator.add(1, 1);
        int resultSubstract1 = calculator.substract(18, 6);
        int resultSubstract2 = calculator.substract(11, 7);
        int resultSubstract3 = calculator.substract(189, 77);

        if (resultAdd1 == 11 && resultAdd2 == 60 && resultAdd3 == 2) {
            System.out.println("Test ok");
        } else {
            System.out.println("Error");
        }

        if (resultSubstract1 == 12 && resultSubstract2 == 4 && resultSubstract3 == 112) {
            System.out.println("Test ok");
        } else {
            System.out.println("Error");
        }


    }
}
