package com.tss.oop_assignment.Assignment_26_05.FoodItem;

public class Burger implements FooditemsInterface {
    private String itemName;
    private double price;

    static int count = 0;

    public Burger(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        count++;
    }

    @Override
    public double displayBill() {

        double gst = price * 2 / 100;
        double finalPrice = price + gst;

        System.out.println("\n===== BURGER INVOICE =====");
        System.out.println("Item Name : " + itemName);
        System.out.println("Base Price : " + price);
        System.out.println("GST 2% : " + gst);
        System.out.println("Final Price : " + finalPrice);

        return finalPrice;
    }

    @Override
    public String toString() {
        return "Burger";
    }
}