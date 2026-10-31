package session_11.assignment;

import java.util.Scanner;
import java.util.Arrays;

public class DiceThrowTally {
    public static void diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) count[roll]++;
        }

        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v]);
            if (v < 6) System.out.print(" ");
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            while (count[v] > 0) {
                sorted[idx++] = v;
                count[v]--;
            }
        }

        System.out.println("Sorted: " + Arrays.toString(sorted));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int[] rolls = new int[n];
        for (int i = 0; i < n; i++) rolls[i] = sc.nextInt();

        diceSort(rolls);
    }
}
