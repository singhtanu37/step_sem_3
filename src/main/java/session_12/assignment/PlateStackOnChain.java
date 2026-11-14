package session_12.assignment;

import java.util.Scanner;

public class PlateStackOnChain {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top = null;
    private int size = 0;

    public void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("push " + plate + " -> top " + top.data + ", size " + size);
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return null;
        }
        String popped = top.data;
        top = top.next;
        size--;
        if (top != null) {
            System.out.println("pop -> " + top.data + ", size " + size);
        } else {
            System.out.println("pop -> stack is empty");
        }
        return popped;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
            return null;
        }
        System.out.println("peek -> " + top.data);
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;

        String line = sc.nextLine().trim();
        if (line.isEmpty() && sc.hasNextLine()) {
            line = sc.nextLine().trim();
        }

        PlateStackOnChain stack = new PlateStackOnChain();
        String[] commands = line.split(",");

        for (String raw : commands) {
            String cmd = raw.trim();
            if (cmd.startsWith("push(") && cmd.endsWith(")")) {
                String plate = cmd.substring(5, cmd.length() - 1).trim();
                stack.push(plate);
            } else if (cmd.equals("pop()")) {
                stack.pop();
            } else if (cmd.equals("peek()")) {
                stack.peek();
            } else if (cmd.equals("isEmpty()")) {
                System.out.println("isEmpty -> " + stack.isEmpty());
            }
        }
    }
}
