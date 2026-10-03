package week_9.cw;

import java.util.Scanner;
import java.util.Locale;

abstract class TravelBooking {
    protected double distanceKm;
    private static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();
    public abstract String getMode();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) { super(distanceKm); }
    @Override
    public double calculateBaseFare() { return distanceKm * 2.0; }
    @Override
    public String getMode() { return "BUS"; }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) { super(distanceKm); }
    @Override
    public double calculateBaseFare() { return distanceKm * 1.5; }
    @Override
    public String getMode() { return "TRAIN"; }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) { super(distanceKm); }
    @Override
    public double calculateBaseFare() { return 2500.0 + (distanceKm * 4.0); }
    @Override
    public String getMode() { return "FLIGHT"; }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            TravelBooking booking = null;

            if (mode.equalsIgnoreCase("BUS")) {
                booking = new BusBooking(distance);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                booking = new TrainBooking(distance);
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                booking = new FlightBooking(distance);
            }

            if (booking != null) {
                System.out.printf(Locale.US, "%s: %.2f%n", booking.getMode(), booking.calculateTotalFare());
            }
        }
    }
}
