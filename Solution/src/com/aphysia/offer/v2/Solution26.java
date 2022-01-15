package com.aphysia.offer.v2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (isSame(current, root2)) return true;
            else {
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return false;
    }

    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        return root1.val == root2.val
                && isSame(root1.left, root2.left)
                && isSame(root1.right, root2.right);
    }
}


