package com.tss.oop_assignment.Assignment_25_05.Assignment_2.model;

 abstract  public class Employee {
   private  String  name;
   private  double  basicSalary ;
   public static int count;


   abstract   public double   calculateSalary();

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public Employee(String name, double basicSalary) {
         this.name = name;
         this.basicSalary = basicSalary;
         count++;

     }

     public static int getCount() {
         return count;
     }

     public double getBasicSalary() {
         return basicSalary;
     }

     @Override
     public String toString() {
         return "Employee{" +
                 "name='" + name + '\'' +
                 ", basicSalary=" + basicSalary +
                 '}';
     }

 }
