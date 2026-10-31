package session_10.assignment;

import java.util.Scanner;

public class DutyRosterRotation {
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        if (n == 0) return names;

        int effectiveK = (int)(k % n);
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            int newPos = (i + effectiveK) % n;
            rotated[newPos] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = sc.next();

        long k = sc.nextLong();
        String[] result = rotateRoster(names, k);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
