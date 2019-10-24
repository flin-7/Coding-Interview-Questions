package com.felix;

import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {

    }

    private static class Node {
        int value;
        List<Node> next;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param a
     * @param b
     * @return
     */
    public static List<Node> shortestPath(Node a, Node b) {
        if (a == null || b == null) return null;

        Queue<Node> toVisit = new LinkedList<>();
        HashMap<Node, Node> parents = new HashMap<>();

        toVisit.add(a);
        parents.put(a, null);

        while (!toVisit.isEmpty()) {
            Node curr = toVisit.remove();
            if (curr == b) break;
            for (Node n : curr.next) {
                if (!parents.containsKey(n)) {
                    toVisit.add(n);
                    parents.put(n, curr);
                }
            }
        }

        if (parents.get(b) == null) return null;

        List<Node> out = new LinkedList<>();
        Node curr = b;
        while (curr != null) {
            out.add(0, curr);
            curr = parents.get(curr);
        }

        return out;
    }
}
