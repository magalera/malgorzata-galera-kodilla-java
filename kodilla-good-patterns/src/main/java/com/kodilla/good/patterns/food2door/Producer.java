package com.kodilla.good.patterns.food2door;

import java.util.List;

public interface Producer {
    boolean process(Product product, Integer quantity);

    List<Product> getProducts();
}
