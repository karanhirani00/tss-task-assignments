package com.tss.oop_assignment.Assignment_26_05.Employee;

public class Developer implements Employe{
    private  String  name;
    private  double  basicSalary ;
    public static int count;




    public Developer(String name,double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
        count++;
    }

    @Override
    public double calculateSalary() {
      return   basicSalary = basicSalary + basicSalary*20/100;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", basicSalary=" + basicSalary +
                '}';
    }
}
