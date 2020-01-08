package com.kodilla.good.patterns.challenges;

public class MailSendOrder implements InformationService {
    @Override
    public void sendEmail(User user) {
        System.out.println("Your order has been shipped");
    }
}
