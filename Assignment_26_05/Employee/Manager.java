package com.tss.oop_assignment.Assignment_26_05.Employee;

public class Manager implements  Employe{
    private  String  name;
    private  double  basicSalary ;
    public static int count;




    public Manager(String name,double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
        count++;
    }

    @Override
    public double calculateSalary() {
        return   basicSalary = basicSalary + basicSalary*35/100;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", basicSalary=" + basicSalary +
                '}';
    }
}
