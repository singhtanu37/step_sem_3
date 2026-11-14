package session_12.practice;

import java.util.Scanner;

public class HostelElectricityBill {
    public static int calculateBill(int units) {
        int amount = 50; // fixed meter charge
        if (units <= 100) {
            amount += units * 3;
        } else if (units <= 200) {
            amount += (100 * 3) + ((units - 100) * 5);
        } else {
            amount += (100 * 3) + (100 * 5) + ((units - 200) * 8);
        }
        return amount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int roomsBilled = 0;
        int totalBill = 0;

        for (int i = 0; i < n; i++) {
            String room = sc.next();
            int units = sc.nextInt();

            if (units < 0) {
                System.out.println(room + ": invalid reading");
            } else {
                int bill = calculateBill(units);
                roomsBilled++;
                totalBill += bill;
                System.out.println(room + ": " + units + " units, bill " + bill);
            }
        }

        System.out.println("Rooms billed " + roomsBilled + ", total " + totalBill);
    }
}
