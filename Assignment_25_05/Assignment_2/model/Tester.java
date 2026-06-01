package com.tss.oop_assignment.Assignment_25_05.Assignment_2.model;

public class Tester extends Employee {

    @Override
    public double calculateSalary() {
        return getBasicSalary() + (getBasicSalary() * 10 / 100);
    }

    public Tester(String name, double basicSalary) {
        super(name, basicSalary);

    }


    @Override
    public String toString() {
        return "Tester{}";
    }
}
