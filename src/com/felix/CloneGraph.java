package com.felix;

import java.util.*;

public class CloneGraph {

    class Node {
        int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        // If start node is null then we cannot do anything
        if (node == null) return null;

        /*
         * vertexMap: Map the original node reference to its clone
         * queue: BFS
         */
        Map<Node, Node> vertexMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Add the start node to the queue. Give the start node a clone in the vertexMap
        queue.add(node);
        vertexMap.put(node, createNode(node.val));

        while (!queue.isEmpty()) {
            // We grab a node. We will express all of the edges coming off of this node.
            Node currVertex = queue.remove();

            for (Node neighbor: currVertex.neighbors) {
                if (vertexMap.containsKey(neighbor)) {
                    vertexMap.put(neighbor, createNode(neighbor.val));
                    queue.add(neighbor);
                }

                /*
                Draw the edge from currVertex's clone to neighbor's clone.
                 */
                vertexMap.get(currVertex).neighbors.add(vertexMap.get(neighbor));
            }
        }

        return vertexMap.get(node);
    }

    private Node createNode(int value) {
        Node newNode = new Node(value, new ArrayList<>());
        return newNode;
    }
}
