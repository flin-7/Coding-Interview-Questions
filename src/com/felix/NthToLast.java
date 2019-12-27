package com.felix;

public class NthToLast {

    private class Node {
        private int value;
        private Node next;
    }

    public Node nthToLast(Node node, int n) {
        Node curr = node;
        Node follower = node;

        // what if n > than length of list?
        for (int i = 0; i < n; i++) {
            if (curr == null) return null;
            curr = curr.next;
        }

        while (curr.next != null) {
            curr = curr.next;
            follower = follower.next;
        }

        return follower;
    }
}
