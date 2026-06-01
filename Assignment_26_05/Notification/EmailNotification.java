package com.tss.oop_assignment.Assignment_26_05.Notification;

public class EmailNotification implements  NotificationInterface{
   public static  int emailcount = 0;

    @Override
    public void sendNotification() {

        System.out.println("Email notification sent");


    }

    public EmailNotification() {
        emailcount++;
    }

    @Override
    public String toString() {
        return "EmailNotification";
    }
}
