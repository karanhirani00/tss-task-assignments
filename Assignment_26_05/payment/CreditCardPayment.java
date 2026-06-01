package com.tss.oop_assignment.Assignment_26_05.payment;

public class CreditCardPayment implements PaymentMethod {

    private int paymentId ;
    private String customerName;
    private double amount;

    private String cardNumber;
    private int cvv;


    public  static int count = 0;

    public CreditCardPayment(int paymentId, String customerName, double amount, String cardNumber, int cvv) {

        this.paymentId = paymentId;
        this.customerName = customerName;
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        count++;
    }


    public void makePayment() {

        System.out.println("Paid " + amount + " using Credit Card");
    }

    public String toString() {

        return "\nPayment Id : " + paymentId +
                "\nCustomer Name : " + customerName +
                "\nAmount : " + amount +
                "\nCard Number : " + cardNumber;
    }

    public static int getCount() {
        return count;
    }
}