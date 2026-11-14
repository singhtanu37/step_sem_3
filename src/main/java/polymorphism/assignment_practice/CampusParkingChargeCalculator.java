package polymorphism.assignment_practice;

import java.util.Scanner;
import java.util.Locale;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
    public abstract String getType();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    @Override
    public double calculateCharge() { return hours * 10.0; }
    @Override
    public String getType() { return "BIKE"; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    @Override
    public double calculateCharge() { return 30.0 + (hours - 1) * 20.0; }
    @Override
    public String getType() { return "CAR"; }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    @Override
    public double calculateCharge() { return Math.max(100.0, hours * 50.0); }
    @Override
    public String getType() { return "TRUCK"; }
}

public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle vehicle = null;

            if (type.equalsIgnoreCase("BIKE")) {
                vehicle = new Bike(hours);
            } else if (type.equalsIgnoreCase("CAR")) {
                vehicle = new Car(hours);
            } else if (type.equalsIgnoreCase("TRUCK")) {
                vehicle = new Truck(hours);
            }

            if (vehicle != null) {
                double charge = vehicle.calculateCharge();
                grandTotal += charge;
                System.out.printf(Locale.US, "%s: %.2f%n", vehicle.getType(), charge);
            }
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }
}
