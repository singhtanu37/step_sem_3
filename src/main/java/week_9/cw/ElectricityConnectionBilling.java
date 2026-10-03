package week_9.cw;

import java.util.Scanner;
import java.util.Locale;

abstract class ElectricityConnection {
    protected double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) { super(units); }
    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
    @Override
    public String getType() { return "HOME"; }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) { super(units); }
    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
    @Override
    public String getType() { return "SHOP"; }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) { super(units); }
    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
    @Override
    public String getType() { return "FACTORY"; }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            ElectricityConnection conn = null;

            if (type.equalsIgnoreCase("HOME")) {
                conn = new HomeConnection(units);
            } else if (type.equalsIgnoreCase("SHOP")) {
                conn = new ShopConnection(units);
            } else if (type.equalsIgnoreCase("FACTORY")) {
                conn = new FactoryConnection(units);
            }

            if (conn != null) {
                double bill = conn.calculateBill();
                grandTotal += bill;
                System.out.printf(Locale.US, "%s: %.2f%n", conn.getType(), bill);
            }
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }
}
