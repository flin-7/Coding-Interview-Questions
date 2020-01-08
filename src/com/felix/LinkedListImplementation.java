package com.felix;

public class LinkedListImplementation {

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public void appendToTail(Node head, int data) {
        Node end = new Node(data);
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
    }

    public Node deleteNode(Node head, int data) {
        Node current = head;

        if (current.data == data) {
            return head.next;
        }

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }
}
