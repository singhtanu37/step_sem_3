package polymorphism.assignment_practice;

import java.util.Scanner;
import java.util.Locale;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();
    public String getName() { return name; }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override
    public double calculateBonus() { return monthlySalary * 0.10; }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override
    public double calculateBonus() { return monthlySalary * 0.05; }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override
    public double calculateBonus() { return 2000.0; }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee emp = null;

            if (type.equalsIgnoreCase("FULLTIME")) {
                emp = new FullTimeEmployee(name, salary);
            } else if (type.equalsIgnoreCase("PARTTIME")) {
                emp = new PartTimeEmployee(name, salary);
            } else if (type.equalsIgnoreCase("INTERN")) {
                emp = new InternEmployee(name, salary);
            }

            if (emp != null) {
                double bonus = emp.calculateBonus();
                grandTotal += bonus;
                System.out.printf(Locale.US, "%s: %.2f%n", emp.getName(), bonus);
            }
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", grandTotal);
    }
}
