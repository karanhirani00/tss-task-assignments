package com.tss.oop_assignment.Assignment_25_05.Assignment_4.model;

 abstract  public class FoodItem {
     private String itemName;
     private double price;
     static int  count = 0;

     public FoodItem(String itemName, double price) {
         this.itemName = itemName;
         this.price = price;


     }

     abstract public double displayBill();
     public String getItemName() {
         return itemName;
     }

     public double getPrice() {
         return price;
     }


     public static int getCount() {
         return count;
     }

     @Override
     public String toString() {
         return "FoodItem{" +
                 "itemName='" + itemName + '\'' +
                 ", price=" + price +
                 '}';
     }

     {
         count++;
     }






 }
