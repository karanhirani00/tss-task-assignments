package com.tss.oop_assignment.Assignment_25_05.Assignment_2.model;

public class Developer extends  Employee {


    public double calculateSalary() {
        return getBasicSalary() +( getBasicSalary() * 20 / 100);
    }



    public Developer(String name, double basicSalary) {
        super(name, basicSalary);


    }


    @Override
    public String toString() {
        return "Developer{}";
    }
}
