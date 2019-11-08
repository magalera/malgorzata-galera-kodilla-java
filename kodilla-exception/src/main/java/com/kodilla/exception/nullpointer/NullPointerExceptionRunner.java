package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {

        User user = null;
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hello");
        } catch (MessageNotSentException e){
            System.out.println(e + "\nMessage is not send," +
                    "but my program still running very well!");
        } finally {
            System.out.println("Processing other logic!");
        }
    }
}
