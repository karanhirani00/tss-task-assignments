package com.tss.oop_assignment.Assignment_25_05.Assignment_1.model;

public class NetBankingPayment extends  Payment{

    public NetBankingPayment(double amount) {
        super(amount);
    }


    public void makePayment() {
        System.out.println(" Paid " +getAmount() + " using Net Banking");
    }



    public String toString() {
        return "NetBankingPayment{}";
    }
}
