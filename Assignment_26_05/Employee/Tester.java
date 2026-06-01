package com.tss.oop_assignment.Assignment_26_05.Employee;

public class Tester implements  Employe{
    private  String  name;
    private  double  basicSalary ;
    public static int count;




    public Tester(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
        count++;
    }

    @Override
    public double calculateSalary() {
        return   basicSalary = basicSalary + basicSalary*10/100;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "name='" + name + '\'' +
                ", basicSalary=" + basicSalary +
                '}';
    }
}
