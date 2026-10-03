package classes_and_objects.assignment_problems;

public class M2_PayrollAccount {
    private double basicSalary;
    private double bonus;

    public M2_PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            System.out.println("Warning: Initial basic salary cannot be negative. Defaulting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = openingBasicSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Warning: Bonus amount must be positive.");
            return;
        }
        this.bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Warning: Tax percentage must be between 0 and 100.");
            return;
        }
        double taxAmount = (this.basicSalary * percent) / 100.0;
        this.basicSalary -= taxAmount;
        System.out.println("Tax deducted: " + (int)percent + "%");
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    public static void main(String[] args) {
        M2_PayrollAccount account = new M2_PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
