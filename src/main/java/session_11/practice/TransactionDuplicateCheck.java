package session_11.practice;

import java.util.Scanner;
import java.util.HashSet;

public class TransactionDuplicateCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        HashSet<String> set = new HashSet<>();
        boolean hasDuplicate = false;

        for (int i = 0; i < n; i++) {
            String tx = sc.next();
            if (!set.add(tx)) hasDuplicate = true;
        }

        System.out.println(hasDuplicate);
    }
}
