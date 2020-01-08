package com.kodilla.good.patterns.challenges;

public class MagazineService implements OrderRepository {
    @Override
    public boolean checkStock(Product product) {
        return true;
    }
}
