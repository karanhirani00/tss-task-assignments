package com.tss.oop_assignment.Assignment_25_05.Assignment_3.test;

import java.util.Scanner;

import com.tss.oop_assignment.Assignment_25_05.Assignment_3.model.EmailNotification;
import com.tss.oop_assignment.Assignment_25_05.Assignment_3.model.Notification;
import com.tss.oop_assignment.Assignment_25_05.Assignment_3.model.PushNotification;
import com.tss.oop_assignment.Assignment_25_05.Assignment_3.model.SMSNotification;

public class NotificationTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many notifications you want to send ");
        int numberOfNotification = scanner.nextInt();

        Notification notifications[] = new Notification[numberOfNotification];
        for (int i = 0; i < numberOfNotification; i++) {

            System.out.println("\n===== Notification Menu =====");

            System.out.println("1. Email Notification");
            System.out.println("2. SMS Notification");
            System.out.println("3. Push Notification");
            System.out.print("Enter Your Choice : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    notifications[i] = new EmailNotification();
                    break;

                case 2:
                    notifications[i] = new SMSNotification();
                    break;

                case 3:
                    notifications[i] = new PushNotification();
                    break;

                default:
                    System.out.println("Enter Valid Choice");
                    i--;
            }
        }

        System.out.println("\n===== All Notification =====");

        for (Notification notification : notifications) {
            notification.sendNotification();
            System.out.println(notification);


            if (notification instanceof EmailNotification) {
                System.out.println("This is Email Notification");
            }

            else if (notification instanceof SMSNotification) {
                System.out.println("This is SMS Notification");
            }

            else if (notification instanceof PushNotification) {
                System.out.println("This is Push Notification");
            }

            System.out.println("----------------------");
        }

        System.out.println("Total Objects Created : " + Notification.getCount());


    }
}