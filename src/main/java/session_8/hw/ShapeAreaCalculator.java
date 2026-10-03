package session_8.hw;

import java.util.Scanner;
import java.util.Locale;

class Shape {
    public double calculateArea() {
        return 0.0;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String shapeType = sc.next();

        if (shapeType.equalsIgnoreCase("Circle")) {
            double radius = sc.nextDouble();
            Circle circle = new Circle(radius);
            System.out.printf(Locale.US, "Circle Area: %.2f%n", circle.calculateArea());
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            double length = sc.nextDouble();
            double width = sc.nextDouble();
            Rectangle rect = new Rectangle(length, width);
            System.out.printf(Locale.US, "Rectangle Area: %.2f%n", rect.calculateArea());
        }
    }
}
