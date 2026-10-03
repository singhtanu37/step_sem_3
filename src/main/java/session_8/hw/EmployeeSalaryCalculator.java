package session_8.hw;

import java.util.Scanner;
import java.util.Locale;

class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public double calculateSalary() {
        return 0.0;
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, double hoursWorked, double hourlyRate) {
        super(name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        String name = sc.next();

        if (type.equalsIgnoreCase("FullTime")) {
            double monthlySalary = sc.nextDouble();
            FullTimeEmployee fte = new FullTimeEmployee(name, monthlySalary);
            System.out.printf(Locale.US, "Employee: %s, Salary: %.2f%n", name, fte.calculateSalary());
        } else if (type.equalsIgnoreCase("PartTime")) {
            double hours = sc.nextDouble();
            double rate = sc.nextDouble();
            PartTimeEmployee pte = new PartTimeEmployee(name, hours, rate);
            System.out.printf(Locale.US, "Employee: %s, Salary: %.2f%n", name, pte.calculateSalary());
        }
    }
}
