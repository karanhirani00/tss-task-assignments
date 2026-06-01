package com.tss.oop_assignment.Assignment_25_05.Assignment_1.model;

public class CreditCardPayment extends Payment{
    public CreditCardPayment(double amount) {
        super(amount);
    }


    public void makePayment() {
        System.out.println("Paid " + getAmount()  + " using Credit Card");
    }

    @Override
    public String toString() {
        return "CreditCardPayment{}";
    }
}
