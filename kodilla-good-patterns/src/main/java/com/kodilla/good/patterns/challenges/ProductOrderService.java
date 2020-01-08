package com.kodilla.good.patterns.challenges;

public class ProductOrderService implements OrderService {

    public boolean order(User user, Product product){
        System.out.println(user + " ordering " + product);
        return true;
    }
}
