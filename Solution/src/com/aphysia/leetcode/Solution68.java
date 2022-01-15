package com.aphysia.leetcode;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution68 {

    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        TreeNode result = commonAncestor(root, p, q);
        return result == null ? -1 : result.val;
    }

    public TreeNode commonAncestor(TreeNode root, int p, int q) {
        if (null == root) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = commonAncestor(root.left, p, q);
        TreeNode right = commonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
