package session_11.practice;

import java.util.Scanner;
import java.util.HashMap;

public class EmployeeIDLookupInUnsortedDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String empId = sc.next();
            String dept = sc.next();
            map.put(empId, dept);
        }

        if (!sc.hasNext()) return;
        String queryId = sc.next();

        System.out.println(map.getOrDefault(queryId, "Unknown"));
    }
}
