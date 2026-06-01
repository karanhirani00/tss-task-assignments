package com.tss.oop_assignment.Assignment_25_05.Assignment_4.test;

import java.util.Scanner;

import com.tss.oop_assignment.Assignment_25_05.Assignment_4.model.Burger;
import com.tss.oop_assignment.Assignment_25_05.Assignment_4.model.Dessert;
import com.tss.oop_assignment.Assignment_25_05.Assignment_4.model.FoodItem;
import com.tss.oop_assignment.Assignment_25_05.Assignment_4.model.Pizza;

public class FoodTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many food items ");
        int numberOfItems = scanner.nextInt();
        scanner.nextLine();

        FoodItem items[] = new FoodItem[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {

            System.out.println("\nEnter Item Name : ");
            String itemName = scanner.nextLine();
            double price;

            while (true) {

                System.out.println("Enter Item Price : ");
                price = scanner.nextDouble();

                if (price > 0) {
                    break;
                }

                System.out.println("Enter Valid Price");
            }

            System.out.println("\n===== FOOD MENU =====");

            System.out.println("1. Pizza");
            System.out.println("2. Burger");
            System.out.println("3. Dessert");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    items[i] = new Pizza(itemName,price);
                    System.out.println("Pizza Added");

                    break;

                case 2:

                    items[i] = new Burger(itemName, price);
                    System.out.println("Burger Added");
                    break;

                case 3:

                    items[i] = new Dessert(itemName, price);
                    System.out.println("Dessert Added");
                    break;

                default:

                    System.out.println("Enter Valid Choice");

                    i--;
            }
        }

        System.out.println("\n===== Food BILL DETAILS =====");

        for (FoodItem item : items) {
            System.out.println(item);

            System.out.println("Final Bill : " + item.displayBill());


            if (item instanceof Pizza) {
                System.out.println("This is Pizza");
            }

            else if (item instanceof Burger) {

                System.out.println("This is Burger");
            }

            else if (item instanceof Dessert) {

                System.out.println("This is Dessert");
            }

            System.out.println("----------------------");
        }

        System.out.println("Total Objects Created : " + FoodItem.getCount());


    }
}