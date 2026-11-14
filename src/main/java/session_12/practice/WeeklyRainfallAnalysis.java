package session_12.practice;

import java.util.Scanner;
import java.util.Locale;

public class WeeklyRainfallAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rain = new double[7];

        for (int i = 0; i < 7; i++) {
            if (!sc.hasNextDouble()) return;
            rain[i] = sc.nextDouble();
        }

        double total = 0.0;
        int wettestIndex = 0;
        int dryDays = 0;

        System.out.print("Rainfall (mm):");
        for (int i = 0; i < 7; i++) {
            System.out.printf(Locale.US, " %.1f", rain[i]);
            total += rain[i];
            if (rain[i] > rain[wettestIndex]) {
                wettestIndex = i;
            }
            if (rain[i] == 0.0) {
                dryDays++;
            }
        }
        System.out.println();

        double average = total / 7.0;
        System.out.printf(Locale.US, "Total Rainfall: %.1f mm%n", total);
        System.out.printf(Locale.US, "Average Rainfall: %.2f mm%n", average);
        System.out.printf(Locale.US, "Wettest Day: Day %d (%.1f mm)%n", (wettestIndex + 1), rain[wettestIndex]);
        System.out.println("Total Dry Days: " + dryDays);
    }
}
