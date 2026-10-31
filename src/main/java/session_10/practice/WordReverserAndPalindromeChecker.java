package session_10.practice;

import java.util.Scanner;

public class WordReverserAndPalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String word = sc.next();

        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        System.out.println("Reversed: " + reversed);
        if (word.equalsIgnoreCase(reversed)) {
            System.out.println("Is Palindrome: Yes");
        } else {
            System.out.println("Is Palindrome: No");
        }
    }
}
