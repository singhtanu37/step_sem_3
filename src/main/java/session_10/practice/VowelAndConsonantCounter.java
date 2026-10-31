package session_10.practice;

import java.util.Scanner;

public class VowelAndConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String word = sc.next();

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) vowels++;
                else consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
