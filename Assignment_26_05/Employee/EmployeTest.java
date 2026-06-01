package com.tss.oop_assignment.Assignment_26_05.Employee;

import java.util.Scanner;



public class EmployeTest{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number Of Employees : ");
        int numberOfEmployee = scanner.nextInt();

        scanner.nextLine();

        Employe employees[] = new Employe[numberOfEmployee];

        for (int i = 0; i < numberOfEmployee; i++) {

            System.out.println("\nEnter Employee Name : ");
            String name = scanner.nextLine();

            double salary;

            while (true) {

                System.out.println("Enter Basic Salary : ");
                salary = scanner.nextDouble();

                if (salary > 0) {
                    break;
                }

                System.out.println("Enter Valid Salary");
            }

            scanner.nextLine();

            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("1. Developer");
            System.out.println("2. Tester");
            System.out.println("3. Manager");

            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    employees[i] = new Developer(name, salary);

                    break;

                case 2:

                    employees[i] = new Tester(name, salary);

                    break;

                case 3:

                    employees[i] = new Manager(name, salary);

                    break;

                default:

                    System.out.println("Invalid Choice");
                    i--;
            }
        }

        System.out.println("\n===== EMPLOYEE DETAILS =====");

        for (Employe employee : employees) {

            System.out.println(employee);

            System.out.println("Final Salary : " + employee.calculateSalary()
            );

            if (employee instanceof Developer) {

                System.out.println("Employee Type : Developer");
            }

            else if (employee instanceof Tester) {

                System.out.println("Employee Type : Tester");

            }

            else if (employee instanceof Manager) {

                System.out.println("Employee Type : Manager");

            }

            System.out.println("----------------------");
        }

        int totalObjects = Developer.count + Tester.count + Manager.count;
        System.out.println("Total Objects Created : " + totalObjects);


    }
}