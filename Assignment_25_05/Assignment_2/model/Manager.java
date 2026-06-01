package com.tss.oop_assignment.Assignment_25_05.Assignment_2.model;

public class Manager extends  Employee{


    public Manager(String name, double basicSalary) {
        super(name, basicSalary);

    }

    @Override
    public double calculateSalary() {
        return getBasicSalary() +getBasicSalary() * 35 / 100;
    }

    @Override
    public String toString() {
        return "Manager{}";
    }
}
