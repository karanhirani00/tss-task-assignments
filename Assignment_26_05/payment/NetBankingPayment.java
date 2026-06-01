package com.tss.oop_assignment.Assignment_26_05.payment;


public class NetBankingPayment implements PaymentMethod {


    private int paymentId;
    private String customerName;
    private double amount;


    private String bankName;
    private String accountNumber;
    private String ifscCode;
    public  static int count = 0;

    public NetBankingPayment(int paymentId, String customerName, double amount, String bankName, String accountNumber,String ifscCode ) {

        this.paymentId = paymentId;
        this.customerName = customerName;
        this.amount = amount;

        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;


        count++;
    }

    @Override
    public void makePayment() {

        System.out.println("\nPaid " + amount +
                " using Net Banking");
    }

    @Override
    public String toString() {

        return "\nPayment Id : " + paymentId +
                "\nCustomer Name : " + customerName +
                "\nAmount : " + amount +
                "\nBank Name : " + bankName +
                "\nAccount Number : " + accountNumber+
                "\nIFSC Code : " + ifscCode;


    }

    public static int getCount() {
        return count;
    }
}
