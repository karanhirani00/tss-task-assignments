package com.tss.oop_assignment.Assignment_25_05.Assignment_2.test;

import java.util.Scanner;

import com.tss.oop_assignment.Assignment_25_05.Assignment_2.model.Developer;
import com.tss.oop_assignment.Assignment_25_05.Assignment_2.model.Employee;
import com.tss.oop_assignment.Assignment_25_05.Assignment_2.model.Manager;
import com.tss.oop_assignment.Assignment_25_05.Assignment_2.model.Tester;

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number Of Employees : ");
        int numberOfEmployee = scanner.nextInt();

        scanner.nextLine();

        Employee employees[] = new Employee[numberOfEmployee];

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

        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("Final Salary : " + employee.calculateSalary());


            if (employee instanceof Developer) {
                System.out.println("Employee Type : Developer");
                System.out.println("Employee name : " +employee.getName());

            }

            else if (employee instanceof Tester) {
                System.out.println("Employee Type : Tester");
                System.out.println("Employee name : " +employee.getName());
            }

            else if (employee instanceof Manager) {
                System.out.println("Employee Type : Manager");
                System.out.println("Employee name : " +employee.getName());
            }

            System.out.println("----------------------");
        }

        System.out.println(
                "Total Objects Created : " + Employee.getCount());



    }
}