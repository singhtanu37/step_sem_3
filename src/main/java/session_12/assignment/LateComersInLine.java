package session_12.assignment;

import java.util.Scanner;

public class LateComersInLine {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    public static Node addLast(Node head, String name) {
        Node newNode = new Node(name);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static void printLine(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int initialCount = sc.nextInt();
        Node head = null;
        for (int i = 0; i < initialCount; i++) {
            head = addLast(head, sc.next());
        }

        if (!sc.hasNextInt()) return;
        int ops = sc.nextInt();
        for (int i = 0; i < ops; i++) {
            String op = sc.next();
            String name = sc.next();
            if (op.equalsIgnoreCase("addFirst")) {
                head = addFirst(head, name);
            } else if (op.equalsIgnoreCase("addLast")) {
                head = addLast(head, name);
            }
        }

        printLine(head);
    }
}
