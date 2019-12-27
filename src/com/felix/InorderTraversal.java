package com.felix;

import java.util.Stack;

public class InorderTraversal {

    private class Node {
        Node left, right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public void inorderTraversal(Node tree) {
        Stack<Node> stack = new Stack<>();
        addLeftToStack(stack, tree);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.println(curr.value);
            if (curr.right != null) {
                addLeftToStack(stack, curr.right);
            }
        }
    }

    public void addLeftToStack(Stack<Node> s, Node n) {
        while (n != null) {
            s.push(n);
            n = n.left;
        }
    }


}
