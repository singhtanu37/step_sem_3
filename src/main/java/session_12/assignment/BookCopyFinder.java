package session_12.assignment;

import java.util.Scanner;

public class BookCopyFinder {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static String find(Node head, String id) {
        int position = 1;
        int firstPos = -1;
        int copies = 0;

        Node current = head;
        while (current != null) {
            if (current.data.equals(id)) {
                if (firstPos == -1) {
                    firstPos = position;
                }
                copies++;
            }
            position++;
            current = current.next;
        }

        if (copies == 0) {
            return id + " not found";
        }
        return id + " first at position " + firstPos + ", copies: " + copies;
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
        String targetId = sc.next();
        System.out.println(find(head, targetId));
    }
}
