package session_10.practice;

import java.util.Scanner;

public class EvenAndOddNumbersCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int evenCount = 0;
        int oddCount = 0;

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}
