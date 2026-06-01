package com.tss.oop_assignment.Assignment_25_05.Assignment_3.model;

public class PushNotification extends Notification {

    public PushNotification() {
        super();
    }

    @Override
    public void sendNotification() {
        System.out.println("Push notification sent");
    }

    @Override
    public String toString() {
        return "Push Notification";
    }
}