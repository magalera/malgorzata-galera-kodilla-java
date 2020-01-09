package com.kodilla.good.patterns.food2door;

public class MailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email, message: " + message);
    }
}
