public class PalindromeChecker {
    public static void main(String[] args) {
        int number = 121;
        int origNumber = number;
        int reversedNumber = 0;
        
        while (number > 0) {
            int digit = number % 10;
            reversedNumber = (reversedNumber * 10) + digit;
            number = number / 10;
        }
        
        System.out.println(origNumber == reversedNumber ? "Palindrome" : "Not a Palindrome");
    }
}
