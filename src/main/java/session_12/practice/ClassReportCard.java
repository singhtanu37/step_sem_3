package session_12.practice;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

class Student {
    private String name;
    private int[] marks;

    public Student(String name, int m1, int m2, int m3) {
        if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100 || m3 < 0 || m3 > 100) {
            throw new IllegalArgumentException(name + " skipped: marks must be 0 to 100");
        }
        this.name = name;
        this.marks = new int[]{m1, m2, m3};
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    public double getAverage() {
        return getTotal() / 3.0;
    }

    public char getGrade() {
        double avg = getAverage();
        if (avg >= 80.0) return 'A';
        if (avg >= 60.0) return 'B';
        if (avg >= 40.0) return 'C';
        return 'F';
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s total=%d avg=%.2f grade=%c",
                name, getTotal(), getAverage(), getGrade());
    }
}

public class ClassReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        ArrayList<Student> validStudents = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();

            try {
                validStudents.add(new Student(name, m1, m2, m3));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Student[] arr = validStudents.toArray(new Student[0]);
        int passes = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].getTotal() < arr[j + 1].getTotal()) {
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ". " + arr[i]);
        }
        System.out.println("Sorted in " + passes + " passes");
    }
}
