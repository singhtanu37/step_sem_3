package polymorphism.assignment_practice;

import java.util.Scanner;
import java.util.Locale;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getType();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount * 0.90; }
    @Override
    public String getType() { return "STUDENT"; }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount * 0.95; }
    @Override
    public String getType() { return "STAFF"; }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount + 10.0; }
    @Override
    public String getType() { return "GUEST"; }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer customer = null;

            if (type.equalsIgnoreCase("STUDENT")) {
                customer = new StudentCustomer(amount);
            } else if (type.equalsIgnoreCase("STAFF")) {
                customer = new StaffCustomer(amount);
            } else if (type.equalsIgnoreCase("GUEST")) {
                customer = new GuestCustomer(amount);
            }

            if (customer != null) {
                double finalAmt = customer.calculateFinalAmount();
                grandTotal += finalAmt;
                System.out.printf(Locale.US, "%s: %.2f%n", customer.getType(), finalAmt);
            }
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }
}
