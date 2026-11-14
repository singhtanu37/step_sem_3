package session_12.practice;

import java.util.Scanner;
import java.util.Locale;

interface PaymentMethod {
    double processPayment(double amount);
    double getFee(double amount);
    double getAmount();
    String getType();
}

class CashPayment implements PaymentMethod {
    private double amount;

    public CashPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double getFee(double amount) {
        return 0.0;
    }

    @Override
    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getType() {
        return "Cash";
    }
}

class CardPayment implements PaymentMethod {
    private double amount;

    public CardPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double getFee(double amount) {
        return amount * 0.02;
    }

    @Override
    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getType() {
        return "Card";
    }
}

class UpiPayment implements PaymentMethod {
    private double amount;

    public UpiPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double getFee(double amount) {
        return 0.0;
    }

    @Override
    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getType() {
        return "UPI";
    }
}

public class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        PaymentMethod[] payments = new PaymentMethod[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double amount = sc.nextDouble();

            if (mode.equalsIgnoreCase("Cash")) {
                payments[i] = new CashPayment(amount);
            } else if (mode.equalsIgnoreCase("Card")) {
                payments[i] = new CardPayment(amount);
            } else if (mode.equalsIgnoreCase("UPI")) {
                payments[i] = new UpiPayment(amount);
            }
        }

        double totalProcessed = 0.0;
        for (PaymentMethod pm : payments) {
            if (pm != null) {
                double amt = pm.getAmount();
                double fee = pm.getFee(amt);
                double processed = pm.processPayment(amt);
                totalProcessed += processed;
                System.out.printf(Locale.US, "%s: amount %.1f, fee %.1f, processed %.1f%n",
                        pm.getType(), amt, fee, processed);
            }
        }
        System.out.printf(Locale.US, "Total Amount Processed: %.1f%n", totalProcessed);
    }
}
