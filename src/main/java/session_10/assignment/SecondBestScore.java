package session_10.assignment;

import java.util.Scanner;

public class SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > highest) {
                secondHighest = highest;
                highest = score;
            } else if (score < highest && score > secondHighest) {
                secondHighest = score;
            }
        }

        return (secondHighest == Integer.MIN_VALUE) ? -1 : secondHighest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();

        System.out.println(secondHighest(scores));
    }
}
