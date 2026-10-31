package session_11.practice;

import java.util.Scanner;

public class WarehouseBinGridScan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];

        int totalItems = 0;
        int maxItems = -1;
        int maxRow = 0, maxCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
                totalItems += grid[i][j];

                if (grid[i][j] > maxItems) {
                    maxItems = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Total = " + totalItems + ", Max = " + maxItems + " at (" + maxRow + ", " + maxCol + ")");
    }
}
