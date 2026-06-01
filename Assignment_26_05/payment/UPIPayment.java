package com.tss.oop_assignment.Assignment_26_05.payment;



public class UPIPayment implements PaymentMethod {

    private int paymentId;
    private String customerName;
    private double amount;

    private String upiId;

    public  static int count = 0;

    public UPIPayment(int paymentId, String customerName, double amount, String upiId) {

        this.paymentId = paymentId;
        this.customerName = customerName;
        this.amount = amount;
        this.upiId = upiId;


        count++;
    }

    @Override
    public void makePayment() {

        System.out.println("Paid " + amount +
                " using UPI");
    }

    @Override
    public String toString() {

        return "\nPayment Id : " + paymentId +
                "\nCustomer Name : " + customerName +
                "\nAmount : " + amount +
                "\nUPI ID : " + upiId ;

    }
}