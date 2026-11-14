package session_12.practice;

import java.util.Scanner;

public class LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;

        String line = sc.nextLine().trim();
        if (line.isEmpty() && sc.hasNextLine()) {
            line = sc.nextLine().trim();
        }

        String[] stack = new String[3];
        int top = -1;

        String[] queue = new String[3];
        int front = 0, rear = 0, qSize = 0;

        String[] commands = line.split(",");
        for (String rawCmd : commands) {
            String cmd = rawCmd.trim();
            if (cmd.isEmpty()) continue;

            if (cmd.startsWith("RETURN ")) {
                String bookId = cmd.substring(7).trim();
                if (top == stack.length - 1) {
                    System.out.println(bookId + " rejected: pile is full");
                } else {
                    stack[++top] = bookId;
                    System.out.println(bookId + " placed on pile");
                }
            } else if (cmd.equals("SHELVE")) {
                if (top == -1) {
                    System.out.println("pile is empty");
                } else {
                    String bookId = stack[top--];
                    System.out.println("shelved " + bookId);
                }
            } else if (cmd.startsWith("WAIT ")) {
                String student = cmd.substring(5).trim();
                if (qSize == queue.length) {
                    System.out.println(student + " rejected: line is full");
                } else {
                    queue[rear] = student;
                    rear = (rear + 1) % queue.length;
                    qSize++;
                    System.out.println(student + " joined the line");
                }
            } else if (cmd.equals("SERVE")) {
                if (qSize == 0) {
                    System.out.println("no one waiting");
                } else {
                    String student = queue[front];
                    front = (front + 1) % queue.length;
                    qSize--;
                    System.out.println("served " + student);
                }
            }
        }
    }
}
