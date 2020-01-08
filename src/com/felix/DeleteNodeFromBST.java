package com.felix;

public class DeleteNodeFromBST {

    class Node {
        Node left, right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public void deleteNode(Node root, int value) {
        root = delete(root, value);
    }

    private Node delete(Node root, int value) {
        if (root == null) return root;

        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = minValue(root.right);

            root.right = delete(root.right, root.value);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }
}
