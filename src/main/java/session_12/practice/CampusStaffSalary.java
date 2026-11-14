package session_12.practice;

import java.util.Scanner;
import java.util.Locale;

class Staff {
    protected String name;
    protected double baseSalary;

    public Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return 0.0;
    }

    public String getRole() {
        return "Staff";
    }

    public double getTotalSalary() {
        return baseSalary + getBonus();
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}

class Teacher extends Staff {
    public Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 5000.0;
    }

    @Override
    public String getRole() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    public LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 2000.0;
    }

    @Override
    public String getRole() {
        return "LabAssistant";
    }
}

public class CampusStaffSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        Staff[] staffList = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double base = sc.nextDouble();

            if (type.equalsIgnoreCase("Teacher")) {
                staffList[i] = new Teacher(name, base);
            } else if (type.equalsIgnoreCase("LabAssistant")) {
                staffList[i] = new LabAssistant(name, base);
            } else {
                staffList[i] = new Staff(name, base);
            }
        }

        double grandTotal = 0.0;
        for (Staff s : staffList) {
            double total = s.getTotalSalary();
            grandTotal += total;
            System.out.printf(Locale.US, "%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                    s.getName(), s.getRole(), s.getBaseSalary(), s.getBonus(), total);
        }
        System.out.printf(Locale.US, "Grand Total Salary: %.1f%n", grandTotal);
    }
}
