package com.kodilla.testing.user;

public class SimpleUser {
    private String simpleUser;
    private String raelName;

    public SimpleUser(String simpleUser, String raelName) {
        this.simpleUser = simpleUser;
        this.raelName = raelName;
    }

    public String getUsername() {
        return simpleUser;
    }

    public String getRaelName() {
        return raelName;
    }
}