package com.tss.oop_assignment.Assignment_25_05.Assignment_1.model;

public class UPIPayment extends  Payment{

    public UPIPayment(double amount) {
        super(amount);
    }


    public void makePayment() {
        System.out.println("Paid " + getAmount()+" using UPI" );
    }



    public String toString() {
        return "UPIPayment{}";
    }
}
