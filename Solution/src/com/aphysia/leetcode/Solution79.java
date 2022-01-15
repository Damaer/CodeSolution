package com.aphysia.leetcode;

public class Solution79 {
    public boolean IsBalanced_Solution(TreeNode root) {
        // 空树
        if(root == null) {
            return true;
        }
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 左子树的高度
        int left = getHeight(root.left);
        if(left < 0) {
            return -1;
        }
        // 右子树的高度
        int right = getHeight(root.right);
        if(right < 0) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
