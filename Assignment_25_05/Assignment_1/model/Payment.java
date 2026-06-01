package com.tss.oop_assignment.Assignment_25_05.Assignment_1.model;

 abstract  public class Payment {
    private   double amount ;
    public static  int count =0;


    public Payment(double amount){
        this.amount= amount;
        count++;

    }


     abstract public  void makePayment();

     public double getAmount() {
         return amount;
     }

     @Override
     public String toString() {
         return "Payment{" +
                 "amount=" + amount +
                 '}';
     }
 }
