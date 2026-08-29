public class GcdCalculator {
    public static void main(String[] args) {
        int number1 = 48, number2 = 18;
        
        while (number2 != 0) {
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }
        System.out.println("GCD is " + number1);
    }
}
