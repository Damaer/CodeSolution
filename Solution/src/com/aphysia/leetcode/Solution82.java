package com.aphysia.leetcode;

public class Solution82 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode curNode, int target) {
        if (curNode == null) {
            return false;
        }
        target = target - curNode.val;
        // 叶子节点并且target减到0，说明符合
        if (curNode.left == null && curNode.right == null && target == 0) {
            return true;
        }
        // 递归左右子树
        return dfs(curNode.left, target) || dfs(curNode.right, target);
    }
}
