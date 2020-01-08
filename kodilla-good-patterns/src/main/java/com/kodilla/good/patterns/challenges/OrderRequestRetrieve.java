package com.kodilla.good.patterns.challenges;

public class OrderRequestRetrieve {

    public OrderRequest retrieve(){

        User user = new User("user1");
        Product product = new Game("Diablo", 99.99);

        return new OrderRequest(user, product);
    }
}
