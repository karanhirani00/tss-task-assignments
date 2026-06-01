package com.tss.oop_assignment.Assignment_26_05.payment;


import java.util.Scanner;

public class PaymentSystem {

    public static void main(String[] args) {

        double totalAmount = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many payments you want to make ?");
        int noOfPayments = scanner.nextInt();
        scanner.nextLine();
        PaymentMethod[] paymentMethods = new PaymentMethod[noOfPayments];

        for (int i = 0; i < noOfPayments; i++) {

            System.out.println("\n========== PAYMENT ==========");
            int paymentId = 101+i;


            System.out.print("Enter Customer Name : ");
            String customerName = scanner.nextLine();

            System.out.print("Enter Amount : ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            if (amount <= 0) {

                System.out.println("Enter Valid Amount");
                i--;
                continue;
            }

            System.out.println("\n===== PAYMENT MENU =====");
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. Net Banking");

            System.out.print("Enter Your Choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Card Number : ");
                    String cardNumber = scanner.nextLine();

                    if(cardNumber.length() != 16) {
                        System.out.println("Card Number Must Be 16 Digits");
                        i--;
                        continue;
                    }



                    System.out.print("Enter CVV : ");
                    int cvv = scanner.nextInt();
                    scanner.nextLine();
                    if(cvv < 100 || cvv > 999) {
                        System.out.println("CVV Must Be 3 Digits");
                        i--;
                        continue;
                    }



                    paymentMethods[i] = new CreditCardPayment(paymentId, customerName, amount, cardNumber, cvv);
                    System.out.println("Payment Done Using Credit Card");
                    totalAmount += amount;

                    break;

                case 2:

                    System.out.print("Enter UPI ID : ");
                    String upiId = scanner.nextLine();

                    paymentMethods[i] = new UPIPayment(paymentId, customerName, amount, upiId);
                    System.out.println("Payment Done Using UPI");
                    totalAmount += amount;

                    break;

                case 3:

                    System.out.println("\n===== SELECT BANK =====");

                    System.out.println("1. SBI");
                    System.out.println("2. HDFC");
                    System.out.println("3. ICICI");

                    System.out.print("Enter Bank Choice : ");
                    int bankChoice = scanner.nextInt();
                    scanner.nextLine();

                    String bankName = "";
                    String ifscCode = "";

                    switch (bankChoice) {

                        case 1:

                            bankName = "SBI";
                            ifscCode = "SBIN0001234";
                            break;

                        case 2:

                            bankName = "HDFC";
                            ifscCode = "HDFC0005678";
                            break;

                        case 3:

                            bankName = "ICICI";
                            ifscCode = "ICIC0009876";
                            break;

                        default:

                            System.out.println("Invalid Bank Choice");
                            i--;
                            continue;
                    }

                    System.out.print("Enter Account Number : ");
                    String accountNumber = scanner.nextLine();

                    if (!(accountNumber.length() == 8)) {

                        System.out.println("Invalid Account Number");
                        i--;
                        continue;
                    }

                    System.out.println("Selected Bank : " + bankName);
                    System.out.println("IFSC Code : " + ifscCode);

                    paymentMethods[i] = new NetBankingPayment(paymentId, customerName, amount, bankName, accountNumber, ifscCode);

                    System.out.println("Payment Done Using Net Banking");
                    totalAmount += amount;

                    break;
                default:
                    System.out.println("Enter Valid Choice");
                    i--;
            }

            System.out.println("--------------------------------");
        }

        System.out.println("\n========== PAYMENT DETAILS ==========");

        for (PaymentMethod payment : paymentMethods) {
            System.out.println(payment);
            payment.makePayment();

            if (payment instanceof CreditCardPayment) {
                System.out.println("This is Credit Card Payment");
            }

            else if (payment instanceof UPIPayment) {
                System.out.println("This is UPI Payment");
            }

            else if (payment instanceof NetBankingPayment) {
                System.out.println("This is Net Banking Payment");
            }

            System.out.println("--------------------------------");
        }

        System.out.println("\nTotal Objects Created : " + (CreditCardPayment.count + NetBankingPayment.count + UPIPayment.count));

        System.out.println("Total Amount : " + totalAmount);


    }
}
