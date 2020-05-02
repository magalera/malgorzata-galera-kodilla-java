package com.kodilla.kodillapatterns2.adapter.company.oldhrsystem;

public class Workers {
    private String workers[][] = {
            {"11111111111", "Jo", "Sm"},
            {"22222222222", "Lo", "Op"},
            {"33333333333", "Ajk", "Lol"},
            {"44444444444", "Ron", "Tok"},
            {"55555555555", "Ijan", "Bob"}
    };

    private double salaries[] = {
            4500.00,
            4350.00,
            5000.00,
            8000.00,
            6850.00
    };

    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
