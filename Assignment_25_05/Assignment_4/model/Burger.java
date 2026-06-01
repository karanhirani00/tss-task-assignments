package com.tss.oop_assignment.Assignment_25_05.Assignment_4.model;

public class Burger extends FoodItem {

    public Burger(String itemName, double price) {

        super(itemName, price);
    }

    @Override
    public double displayBill() {

        return getPrice() + (getPrice() * 2/100);
    }

    @Override
    public String toString() {

        return "Burger Item Name = "
                + getItemName()
                + ", Final Bill = "
                + displayBill() + "";
    }
}