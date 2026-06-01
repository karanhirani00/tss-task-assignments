package com.tss.oop_assignment.Assignment_25_05.Assignment_3.model;

abstract public class Notification {

    static int count = 0;

    public Notification() {
        count++;
    }


    abstract public void sendNotification();


    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Notification Object";
    }
}