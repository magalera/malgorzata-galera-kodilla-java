package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String xy = secondChallenge.probablyIWillThrowException(0, 5);
            System.out.println(xy);
        } catch (Exception e) {
            System.out.println("Something went wrong. Error: " + e);
        } finally {
            System.out.println("I'm gonna be here...always!");
        }
    }
}
