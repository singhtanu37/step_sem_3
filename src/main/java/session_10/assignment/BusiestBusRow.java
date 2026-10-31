package session_10.assignment;

import java.util.Scanner;

public class BusiestBusRow {
    public static void busiestRow(int[][] grid) {
        int maxTotal = -1;
        int bestRowIndex = 0;

        for (int i = 0; i < grid.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentTotal += grid[i][j];
            }
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRowIndex = i;
            }
        }

        System.out.println("Row " + bestRowIndex + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        busiestRow(grid);
    }
}
