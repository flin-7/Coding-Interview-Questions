package com.felix;

public class ValidBST {

    private class Node {
        private int value;
        private Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * O(n)
     * @param n
     * @return
     */
    public boolean isBST(Node n) {
        return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node n, int min, int max) {
        if (n == null) return true;
        if (n.value < min || n.value > max) return false;
        return isBST(n.left, min, n.value) && isBST(n.right, n.value + 1, max);
    }
}
