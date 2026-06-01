package com.tss.oop_assignment.Assignment_26_05.Notification;


public class SMSNotification implements NotificationInterface {

    public static int smsCount = 0;

    public SMSNotification() {

        smsCount++;
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS Notification Sent");
    }

    @Override
    public String toString() {
        return "SMSNotification";
    }
}
