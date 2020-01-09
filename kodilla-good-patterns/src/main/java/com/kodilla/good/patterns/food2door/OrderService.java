package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private NotificationService notificationService;

    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public List<Producer> getProducers() {
        List<Producer> producers = new ArrayList<>();
        producers.add(new ExtraFoodShopProducer());
        producers.add(new GlutenFreeShopProducer());
        producers.add(new HealthyShopProducer());
        return producers;
    }

    public boolean order(Producer producer, Product product, Integer quantity) {
        boolean ordered = producer.process(product, quantity);
        if (ordered) {
            notificationService.sendNotification("Your order will be send.");
        } else {
            notificationService.sendNotification("Your order can not be completed.");
        }
        return ordered;

    }
}
