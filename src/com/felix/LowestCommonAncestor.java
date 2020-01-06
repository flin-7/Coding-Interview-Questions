package com.felix;

import java.util.Stack;

public class LowestCommonAncestor {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == q.val) return p;

        Stack<TreeNode> pathToP = pathTo(root, p);
        Stack<TreeNode> pathToQ = pathTo(root, q);

        if (pathToP == null || pathToQ == null) return null;

        TreeNode prev = null;

        while (!pathToP.isEmpty() && !pathToQ.isEmpty()) {
            TreeNode s = pathToP.pop();
            TreeNode t = pathToQ.pop();
            if (s.val == t.val) prev = s;
            else break;
        }

        return prev;
    }

    public Stack<TreeNode> pathTo(TreeNode root, TreeNode n) {
        if (root == null) return null;
        if (root.val == n.val) {
            Stack<TreeNode> s = new Stack<>();
            s.push(root);
            return s;
        }

        Stack<TreeNode> left = pathTo(root.left, n);
        Stack<TreeNode> right = pathTo(root.right, n);

        if (left != null) {
            left.push(root);
            return left;
        }

        if (right != null) {
            right.push(root);
            return right;
        }

        return null;
    }
}
