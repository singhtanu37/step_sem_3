package classes_and_objects.assignment_problems;

public class M3_EmployeeProfile {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public M3_EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public M3_EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        M3_EmployeeProfile permanent = new M3_EmployeeProfile("E-101", "Divya", 65000.0);
        M3_EmployeeProfile intern = new M3_EmployeeProfile("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
