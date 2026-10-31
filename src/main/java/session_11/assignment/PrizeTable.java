package session_11.assignment;

import java.util.Scanner;
import java.util.Arrays;

public class PrizeTable {
    public static void prizeTable(int[] marks) {
        int n = marks.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) maxIdx = j;
            }
            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }

        System.out.println(Arrays.toString(marks) + "   swaps = " + swaps);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) marks[i] = sc.nextInt();

        prizeTable(marks);
    }
}
