package com.felix;

import java.util.*;

public class AllNodesDistanceKFromStart {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode treeRoot, TreeNode startNode, int targetDistance) {
        /*
        Create the node to parent map and populate it
         */
        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        populateNodeToParentMap(nodeToParentMap, treeRoot, null);

        /*
        Create the queue that we will use for the BFS.
        Add the start node to the queue
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);

        /*
        HashMap keeps track of nodes we have visited so
        that we do not go back and revisit what has already been
        processed and cause an infinite cycle
         */
        Set<TreeNode> seen = new HashSet<>();
        seen.add(startNode);

        /*
        When our search starts, we are standing at layer 0
         */
        int currentLayer = 0;

        while (!queue.isEmpty()) {
            /*
            Is this the layer we want? If so, extract and return it
             */
            if (currentLayer == targetDistance) {
                return extractLayerFromQueue(queue);
            }

            /*
            How large is this layer? Let's process all node in the layer.
            BFS
             */
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                /*
                Pull a nod from the search queue, we are going to basically
                use our current layer to populate the next layer of nodes
                that we need to search in the next while loop iteration
                 */
                TreeNode currentNode = queue.poll();

                /*
                Has left been touched before?
                No?
                1) Add it to the seen hash map
                2) Add it to the search queue
                 */
                if (currentNode.left != null && !seen.contains(currentNode.left)) {
                    seen.add(currentNode.left);
                    queue.offer(currentNode.left);
                }

                /*
                Has right been touched before?
                No?
                1) Add it to the seen hash map
                2) Add it to the search queue
                 */
                if (currentNode.right != null && !seen.contains(currentNode.right)) {
                    seen.add(currentNode.right);
                    queue.offer(currentNode.right);
                }

                /*
                Has node's parent been touched before?
                No?
                1) Add it to the seen hash map
                2) Add it to the search queue
                 */
                TreeNode parentOfCurrentNode = nodeToParentMap.get(currentNode);
                if (parentOfCurrentNode != null && !seen.contains(parentOfCurrentNode)) {
                    seen.add(parentOfCurrentNode);
                    queue.offer(parentOfCurrentNode);
                }
            }

            /*
            Advance the layer for the next iteration
             */
            currentLayer++;
        }

        return new ArrayList<Integer>();
    }

    private void populateNodeToParentMap(Map<TreeNode, TreeNode> nodToParentMap, TreeNode root, TreeNode parent) {
        if (root == null) return;

        nodToParentMap.put(root, parent);

        /*
        Go left and after that go right. The call that we make next
        will have what we call 'root' now as the 'parent' value so
        we can do the mapping in THAT call stack frame...and so on
         */
        populateNodeToParentMap(nodToParentMap, root.left, root);
        populateNodeToParentMap(nodToParentMap, root.right, root);
    }

    private List<Integer> extractLayerFromQueue(Queue<TreeNode> queue) {
        List<Integer> extractedList = new ArrayList<>();
        for (TreeNode node: queue) {
            extractedList.add(node.val);
        }
        return extractedList;
    }
}
