package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShopProducer implements Producer {
    @Override
    public boolean process(Product product, Integer quantity) {
        System.out.println(product + "x" + quantity + " ordering from ExtraFoodShop");
        return true;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Shorma", "Dinner"));
        return products;
    }
}
