package com.kodilla.good.patterns.challenges;

public class MailDeliveredOrder implements InformationService {
    @Override
    public void sendEmail(User user) {
        System.out.println("Your order has been delivered");
    }
}
