package com.tss.oop_assignment.Assignment_26_05.FoodItem;



public class Dessert implements FooditemsInterface {


        private String itemName;
        private double price;
        static int count = 0;

        public Dessert(String itemName, double price) {
            this.itemName = itemName;
            this.price = price;

            count++;
        }

        @Override
        public double displayBill() {

            double gst = price * 8 / 100;
            double finalPrice = price + gst;
            System.out.println("\n===== DESSERT INVOICE =====");
            System.out.println("Item Name : " + itemName);
            System.out.println("Base Price : " + price);
            System.out.println("GST 8% : " + gst);
            System.out.println("Final Price : " + finalPrice);
            return finalPrice;
        }



        @Override
        public String toString() {

            return "Dessert";
        }
}