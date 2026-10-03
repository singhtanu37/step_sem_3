package session_8.hw;

import java.util.Scanner;
import java.util.Locale;

class Course {
    protected String courseName;
    protected double baseFee;

    public Course(String courseName, double baseFee) {
        this.courseName = courseName;
        this.baseFee = baseFee;
    }

    public double calculateTotalFee() {
        return baseFee;
    }
}

class OnlineCourse extends Course {
    private double platformFee;

    public OnlineCourse(String courseName, double baseFee, double platformFee) {
        super(courseName, baseFee);
        this.platformFee = platformFee;
    }

    @Override
    public double calculateTotalFee() {
        return baseFee + platformFee;
    }
}

class OnSiteCourse extends Course {
    private double labFee;

    public OnSiteCourse(String courseName, double baseFee, double labFee) {
        super(courseName, baseFee);
        this.labFee = labFee;
    }

    @Override
    public double calculateTotalFee() {
        return baseFee + labFee;
    }
}

public class CourseFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        String name = sc.next();
        double baseFee = sc.nextDouble();

        if (type.equalsIgnoreCase("Online")) {
            double platformFee = sc.nextDouble();
            OnlineCourse oc = new OnlineCourse(name, baseFee, platformFee);
            System.out.printf(Locale.US, "Course: %s, Total Fee: %.2f%n", name, oc.calculateTotalFee());
        } else if (type.equalsIgnoreCase("OnSite")) {
            double labFee = sc.nextDouble();
            OnSiteCourse osc = new OnSiteCourse(name, baseFee, labFee);
            System.out.printf(Locale.US, "Course: %s, Total Fee: %.2f%n", name, osc.calculateTotalFee());
        }
    }
}
