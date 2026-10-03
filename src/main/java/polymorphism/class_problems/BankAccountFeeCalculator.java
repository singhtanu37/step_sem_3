package session_8.hw;

import java.util.Scanner;
import java.util.Locale;

class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double calculateFee() {
        return 0.0;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        if (balance < 1000) {
            return 25.0;
        }
        return 0.0;
    }
}

class CurrentAccount extends BankAccount {
    private int transactions;

    public CurrentAccount(String accountNumber, double balance, int transactions) {
        super(accountNumber, balance);
        this.transactions = transactions;
    }

    @Override
    public double calculateFee() {
        if (transactions > 50) {
            return (transactions - 50) * 2.0;
        }
        return 0.0;
    }
}

public class BankAccountFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        String accNum = sc.next();
        double balance = sc.nextDouble();

        if (type.equalsIgnoreCase("Savings")) {
            SavingsAccount sa = new SavingsAccount(accNum, balance);
            System.out.printf(Locale.US, "Account: %s, Maintenance Fee: %.2f%n", accNum, sa.calculateFee());
        } else if (type.equalsIgnoreCase("Current")) {
            int trans = sc.nextInt();
            CurrentAccount ca = new CurrentAccount(accNum, balance, trans);
            System.out.printf(Locale.US, "Account: %s, Maintenance Fee: %.2f%n", accNum, ca.calculateFee());
        }
    }
}
