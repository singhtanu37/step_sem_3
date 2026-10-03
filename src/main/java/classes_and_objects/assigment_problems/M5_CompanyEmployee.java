package classes_and_objects.assigment_problems;

public class M5_CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public M5_CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        M5_CompanyEmployee e1 = new M5_CompanyEmployee("Alice", 50000);
        M5_CompanyEmployee e2 = new M5_CompanyEmployee("Bob", 60000);
        M5_CompanyEmployee e3 = new M5_CompanyEmployee("Charlie", 70000);

        M5_CompanyEmployee.printCompanyInfo();
    }
}
