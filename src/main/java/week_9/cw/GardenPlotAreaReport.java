package week_9.cw;

import java.util.Scanner;
import java.util.Locale;

abstract class Plot {
    protected String owner;
    public Plot(String owner) { this.owner = owner; }
    public abstract double calculateArea();
    public abstract String getShape();
    public String getOwner() { return owner; }
}

class CirclePlot extends Plot {
    private double radius;
    public CirclePlot(String owner, double radius) { super(owner); this.radius = radius; }
    @Override public double calculateArea() { return Math.PI * radius * radius; }
    @Override public String getShape() { return "CIRCLE"; }
}

class RectanglePlot extends Plot {
    private double length, width;
    public RectanglePlot(String owner, double length, double width) { super(owner); this.length = length; this.width = width; }
    @Override public double calculateArea() { return length * width; }
    @Override public String getShape() { return "RECTANGLE"; }
}

class TrianglePlot extends Plot {
    private double base, height;
    public TrianglePlot(String owner, double base, double height) { super(owner); this.base = base; this.height = height; }
    @Override public double calculateArea() { return 0.5 * base * height; }
    @Override public String getShape() { return "TRIANGLE"; }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalArea = 0;
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot plot = null;
            if (shape.equalsIgnoreCase("CIRCLE")) plot = new CirclePlot(owner, sc.nextDouble());
            else if (shape.equalsIgnoreCase("RECTANGLE")) plot = new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble());
            else if (shape.equalsIgnoreCase("TRIANGLE")) plot = new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble());
            if (plot != null) {
                double area = plot.calculateArea();
                totalArea += area;
                System.out.printf(Locale.US, "%s (%s): %.2f%n", plot.getOwner(), plot.getShape(), area);
            }
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", totalArea);
    }
}
