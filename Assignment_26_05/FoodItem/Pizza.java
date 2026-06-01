package com.tss.oop_assignment.Assignment_26_05.FoodItem;

public class Pizza implements FooditemsInterface {



        private String itemName;
        private double price;
        static int count = 0;

        public Pizza(String itemName, double price) {
            this.itemName = itemName;
            this.price = price;
            count++;
        }


        public double displayBill() {

            double gst = price * 5 / 100;
            double finalPrice = price + gst;
            System.out.println("\n===== PIZZA INVOICE =====");
            System.out.println("Item Name : " + itemName);
            System.out.println("Base Price : " + price);
            System.out.println("GST 5% : " + gst);
            System.out.println("Final Price : " + finalPrice);

            return finalPrice;
        }

        @Override
        public String toString() {

            return "Pizza";
        }
}