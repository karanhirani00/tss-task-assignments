package com.tss.oop_assignment.Assignment_25_05.Assignment_3.model;

public class SMSNotification extends Notification {

    public SMSNotification() {
        super();
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS notification sent");
    }

    @Override
    public String toString() {
        return "SMS Notification";
    }
}