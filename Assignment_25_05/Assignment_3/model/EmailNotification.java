package com.tss.oop_assignment.Assignment_25_05.Assignment_3.model;



public class EmailNotification extends Notification {

    public EmailNotification() {
        super();
    }


    public void sendNotification() {
        System.out.println("Email notification sent");
    }

    @Override
    public String toString() {
        return "Email Notification";
    }
}
