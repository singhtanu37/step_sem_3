package session_11.practice;

import java.util.Scanner;
import java.util.HashSet;

public class PairWithTargetSumUnsorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int target = sc.nextInt();
        HashSet<Integer> seen = new HashSet<>();
        boolean found = false;

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("True (" + complement + " + " + num + ")");
                found = true;
                break;
            }
            seen.add(num);
        }

        if (!found) System.out.println("False");
    }
}
