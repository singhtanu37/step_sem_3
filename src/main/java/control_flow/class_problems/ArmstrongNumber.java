public class ArmstrongNumber {
    public static void main(String[] args) {
        int number = 153;
        int origNumber = number;
        int sum = 0;
        
        while (number > 0) {
            int digit = number % 10;
            sum += (digit * digit * digit);
            number = number / 10;
        }
        
        System.out.println(sum == origNumber ? "Armstrong number" : "Not an Armstrong number");
    }
}
