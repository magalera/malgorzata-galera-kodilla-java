package com.kodilla.good.patterns.challenges;

public class Application {
    public static void main(String[] args) {

        OrderRequestRetrieve orderRequestRetrieve = new OrderRequestRetrieve();
        OrderRequest orderRequest = orderRequestRetrieve.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new MailSendOrder(), new ProductOrderService(), new MagazineService());
        orderProcessor.process(orderRequest);
    }
}
