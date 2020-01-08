package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(InformationService informationService, OrderService orderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process (OrderRequest orderRequest) {
        boolean inStock = orderRepository.checkStock(orderRequest.getProduct());

        if (inStock){
            informationService.sendEmail(orderRequest.getUser());
            orderService.order(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), true);
        }
        return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), false);
    }
}
