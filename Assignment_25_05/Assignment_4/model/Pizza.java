package com.tss.oop_assignment.Assignment_25_05.Assignment_4.model;

public class Pizza extends FoodItem {

    public Pizza(String itemName, double price) {
        super(itemName, price);
    }


    public double displayBill() {
        return getPrice() + (getPrice() * 5/100);
    }

    @Override
    public String toString() {

        return "Pizza Item Name = "
                + getItemName()
                + ", Final Bill = "
                + displayBill() + "";
    }
}