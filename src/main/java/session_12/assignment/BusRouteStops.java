package session_12.assignment;

import java.util.Scanner;

public class BusRouteStops {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node build(String[] stops) {
        if (stops == null || stops.length == 0) return null;
        Node head = new Node(stops[0]);
        Node current = head;
        for (int i = 1; i < stops.length; i++) {
            current.next = new Node(stops[i]);
            current = current.next;
        }
        return head;
    }

    public static void printRoute(Node head) {
        if (head == null) {
            System.out.println("null");
            System.out.println("Stops: 0, First: null, Last: null");
            return;
        }

        int count = 0;
        String first = head.data;
        String last = head.data;
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            last = current.data;
            count++;
            current = current.next;
        }
        System.out.println("null");
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        Node head = build(stops);
        printRoute(head);
    }
}
