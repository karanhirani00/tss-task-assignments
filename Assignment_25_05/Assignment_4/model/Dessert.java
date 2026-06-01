package com.tss.oop_assignment.Assignment_25_05.Assignment_4.model;

public class Dessert extends FoodItem {

    public Dessert(String itemName, double price) {
        super(itemName, price);
    }


    public double displayBill() {

        return getPrice() + (getPrice() * 8/100);
    }


    public String toString() {

        return "Dessert Item Name = "
                + getItemName()
                + ", Final Bill = "
                + displayBill()  ;
    }
}