package com.felix;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrder {

    private class Node {
        int value;
        Node left;
        Node right;
    }

    private void traverse(Node tree) {
        if (tree == null) {
            return;
        }
        Queue<Node> toVisited = new LinkedList<>();
        toVisited.add(tree);
        while (!toVisited.isEmpty()) {
            Node curr = toVisited.remove();
            System.out.println(curr.value);
            if (curr.left != null) {
                toVisited.add(curr.left);
            }
            if (curr.right != null) {
                toVisited.add(curr.right);
            }
        }
    }
}
