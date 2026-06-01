package com.tss.oop_assignment.Assignment_25_05.Assignment_1.test;

import com.tss.oop_assignment.Assignment_25_05.Assignment_1.model.CreditCardPayment;
import com.tss.oop_assignment.Assignment_25_05.Assignment_1.model.NetBankingPayment;
import com.tss.oop_assignment.Assignment_25_05.Assignment_1.model.Payment;
import com.tss.oop_assignment.Assignment_25_05.Assignment_1.model.UPIPayment;


import java.util.Scanner;

public class PaymentSystem {

    public static void main(String[] args) {
        double totolamount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many time you have to make payment");
        int noOfPayment =scanner.nextInt();
        Payment payments[] = new  Payment[noOfPayment];


        for(int i =0; i<noOfPayment ;i++){
           System.out.println("enter your amount");
           double amount = scanner.nextDouble();
            if(amount <= 0) {
                System.out.println("Enter valid amount");
                i--;
                continue;
            }

           System.out.println("\n===== PAYMENT MENU =====");
           System.out.println("1. Credit Card");
           System.out.println("2. UPI");
           System.out.println("3. Net Banking");


           int choice ;
           System.out.println("enter your choice");
           choice  = scanner.nextInt();

           if(choice ==1){
               payments[i] = new CreditCardPayment(amount);
               System.out.println("payment done using  creditcard");
               totolamount +=amount;
           } else if (choice==2) {
               payments[i] = new UPIPayment(amount);
               System.out.println("payment done using  UPI");
               totolamount +=amount;

           } else if (choice == 3) {
              payments[i] = new NetBankingPayment(amount);
               System.out.println("payment done using netBanking ");
               totolamount +=amount;
               System.out.println("-------------------------------");
           }else {
               System.out.println("enter a valid choice");
               i--;
           }


       }
        for(Payment payment : payments){

            payment.makePayment();

            if(payment instanceof CreditCardPayment){
                System.out.println("This is Credit Card Payment");
            }
            else if(payment instanceof UPIPayment){
                System.out.println("This is UPI Payment");
            }
            else if(payment instanceof NetBankingPayment){
                System.out.println("This is Net Banking Payment");
            }

            System.out.println("----------------------------------");
        }

        System.out.println("Total Objects Created : "+ Payment.count  );
        System.out.println();
        System.out.println("total amount "+totolamount);

    }



}