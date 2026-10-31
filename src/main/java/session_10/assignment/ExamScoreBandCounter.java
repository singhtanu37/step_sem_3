package session_10.assignment;

import java.util.Scanner;

public class ExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        int firstPos = findFirstGreaterOrEqual(scores, low);
        int lastPos = findFirstStrictlyGreater(scores, high);
        return lastPos - firstPos;
    }

    private static int findFirstGreaterOrEqual(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static int findFirstStrictlyGreater(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();

        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(countInBand(scores, low, high));
    }
}
