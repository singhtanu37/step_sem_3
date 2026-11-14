package session_12.assignment;

import java.util.Scanner;

public class CancelBooking {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(booking)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println(booking + " not found");
        }

        return head;
    }

    public static void printChain(Node head) {
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

        int n = sc.nextInt();
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.next());
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        if (!sc.hasNext()) return;
        String cancelId = sc.next();

        head = removeFirst(head, cancelId);
        printChain(head);
    }
}
