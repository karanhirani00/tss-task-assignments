package com.tss.oop_assignment.Assignment_26_05.Notification;




import java.util.Scanner;

public class NotificationTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many notifications you want to send ?");
        int numberOfNotification = scanner.nextInt();

        NotificationInterface notifications[] = new NotificationInterface[numberOfNotification];

        for (int i = 0; i < numberOfNotification; i++) {

            System.out.println("\n===== NOTIFICATION MENU =====");

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

        System.out.println("\n===== ALL NOTIFICATIONS =====");

        for (NotificationInterface notification : notifications) {

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

        int totalObjects = EmailNotification.emailcount+ SMSNotification.smsCount + PushNotification.pushCount;
        System.out.println("Total Objects Created : " + totalObjects);


    }
}