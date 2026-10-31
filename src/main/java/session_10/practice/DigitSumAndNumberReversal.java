package session_10.practice;

import java.util.Scanner;

public class DigitSumAndNumberReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int num = sc.nextInt();

        int temp = Math.abs(num);
        int sum = 0;
        int reversed = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reversed: " + reversed);
    }
}
