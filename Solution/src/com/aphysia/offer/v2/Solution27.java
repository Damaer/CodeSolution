package com.aphysia.offer.v2;

public class Solution27 {

    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        } else {
            root = reverse(root);
        }
    }

    public static TreeNode reverse(TreeNode root) {
        if (root == null) {
            return root;
        } else {
            TreeNode left = reverse(root.right);
            TreeNode right = reverse(root.left);
            root.left = left;
            root.right =right;
            return root;
        }
    }
}
