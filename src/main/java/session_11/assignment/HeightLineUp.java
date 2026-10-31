package session_11.assignment;

import java.util.Scanner;
import java.util.Arrays;

public class HeightLineUp {
    public static void lineUp(int[] heights) {
        int n = heights.length;
        int pass = 1;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped) {
                System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
                pass++;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) heights[i] = sc.nextInt();

        lineUp(heights);
    }
}
