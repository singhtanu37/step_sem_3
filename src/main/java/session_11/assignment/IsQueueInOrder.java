package session_11.assignment;

import java.util.Scanner;

public class IsQueueInOrder {
    public static int firstBreak(int[] tokens) {
        if (tokens.length <= 1) return -1;

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int[] tokens = new int[n];
        for (int i = 0; i < n; i++) tokens[i] = sc.nextInt();

        System.out.println(firstBreak(tokens));
    }
}
