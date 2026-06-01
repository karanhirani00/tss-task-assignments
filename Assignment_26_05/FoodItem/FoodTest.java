package com.tss.oop_assignment.Assignment_26_05.FoodItem;

import java.util.Scanner;

public class FoodTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double grandTotal = 0;

        System.out.println("How Many Food Items ?");
        int numberOfItems = scanner.nextInt();

        scanner.nextLine();

        FooditemsInterface foods[] = new FooditemsInterface[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {

            System.out.println("\n===== FOOD MENU =====");

            System.out.println("1. Pizza");
            System.out.println("2. Burger");
            System.out.println("3. Dessert");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Item Name : ");
            String itemName = scanner.nextLine();

            System.out.print("Enter Price : ");
            double price = scanner.nextDouble();

            scanner.nextLine();

            if(price <= 0) {

                System.out.println("Enter Valid Price");
                i--;
                continue;
            }

            switch (choice) {

                case 1:
                    foods[i] = new Pizza(itemName, price);
                    break;

                case 2:

                    foods[i] = new Burger(itemName, price);
                    break;

                case 3:

                    foods[i] = new Dessert(itemName, price);
                    break;

                default:

                    System.out.println("Invalid Choice");
                    i--;
            }
        }

        System.out.println("\n===== FINAL INVOICE =====");

        for (FooditemsInterface food : foods) {
            grandTotal += food.displayBill();
            if(food instanceof Pizza) {
                System.out.println("Food Type : Pizza");
            }

            else if(food instanceof Burger) {
                System.out.println("Food Type : Burger");
            }

            else if(food instanceof Dessert) {
                System.out.println("Food Type : Dessert");
            }

            System.out.println("----------------------------");
        }
        System.out.println("Grand Total : " + grandTotal);

        int totalObjects = Pizza.count + Burger.count + Dessert.count;
        System.out.println("\nTotal Food Objects : " + totalObjects);


    }
}
