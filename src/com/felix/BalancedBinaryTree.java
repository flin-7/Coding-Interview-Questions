package com.felix;

public class BalancedBinaryTree {

    private class Node {
        Node left, right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean isBalanced(Node n) {
        if (balancedHeight(n) > -1) return true;
        return false;
    }

    private int balancedHeight(Node n) {
        if (n == null) return 0;

        int h1 = balancedHeight(n.left);
        int h2 = balancedHeight(n.right);

        if (h1 == -1 || h2 == -1) return -1;
        if (Math.abs(h1 - h2) > 1) return -1;

        if (h1 > h2) {
            return h1 + 1;
        } else {
            return h2 + 1;
        }
    }
}
