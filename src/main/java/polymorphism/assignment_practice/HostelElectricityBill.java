package polymorphism.assignment_practice;

import java.util.Scanner;
import java.util.Locale;

abstract class Room {
    protected double units;

    public Room(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class SingleRoom extends Room {
    public SingleRoom(double units) { super(units); }
    @Override
    public double calculateBill() { return units * 8.0; }
    @Override
    public String getType() { return "SINGLE"; }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() { return (units * 6.0) / occupants; }
    @Override
    public String getType() { return "SHARED"; }
}

class ACRoom extends Room {
    public ACRoom(double units) { super(units); }
    @Override
    public double calculateBill() { return (units * 10.0) + 200.0; }
    @Override
    public String getType() { return "AC"; }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            Room room = null;

            if (type.equalsIgnoreCase("SINGLE")) {
                room = new SingleRoom(units);
            } else if (type.equalsIgnoreCase("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            } else if (type.equalsIgnoreCase("AC")) {
                room = new ACRoom(units);
            }

            if (room != null) {
                double bill = room.calculateBill();
                grandTotal += bill;
                System.out.printf(Locale.US, "%s: %.2f%n", room.getType(), bill);
            }
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }
}
