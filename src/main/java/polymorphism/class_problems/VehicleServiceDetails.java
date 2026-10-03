package session_8.hw;

import java.util.Scanner;

class Vehicle {
    protected String brand;
    protected String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void displayService() {
        System.out.println("General Vehicle Service");
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayService() {
        System.out.println("Car Service: Oil change, tire rotation, and full inspection for " + brand + " " + model + " (" + numberOfDoors + " doors).");
    }
}

class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String brand, String model, boolean hasCarrier) {
        super(brand, model);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayService() {
        String carrierStatus = hasCarrier ? "with carrier" : "without carrier";
        System.out.println("Bike Service: Chain lubrication, brake check, and tuning for " + brand + " " + model + " (" + carrierStatus + ").");
    }
}

public class VehicleServiceDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        String brand = sc.next();
        String model = sc.next();

        if (type.equalsIgnoreCase("Car")) {
            int doors = sc.nextInt();
            Car car = new Car(brand, model, doors);
            car.displayService();
        } else if (type.equalsIgnoreCase("Bike")) {
            boolean carrier = sc.nextBoolean();
            Bike bike = new Bike(brand, model, carrier);
            bike.displayService();
        }
    }
}
