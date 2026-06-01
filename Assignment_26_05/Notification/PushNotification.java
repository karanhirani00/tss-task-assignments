package com.tss.oop_assignment.Assignment_26_05.Notification;

public class PushNotification implements NotificationInterface {

    public static int pushCount = 0;

    public PushNotification() {
        pushCount++;
    }

    @Override
    public void sendNotification() {
        System.out.println("Push Notification Sent");
    }

    @Override
    public String toString() {
        return "PushNotification";
    }
}

