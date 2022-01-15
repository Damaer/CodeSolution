package com.aphysia.leetcode;

public class Solution84 {
    public int sum = 0;

    public void dfs(TreeNode root, int sum) {
        if (null == root) return;
        sum -= root.val;
        if (sum == 0) {
            this.sum++;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    public int FindPath(TreeNode root, int sum) {
        if (null == root) return this.sum;
        // 当前节点往下遍历
        dfs(root, sum);
        // 在左子树查找（不包括当前节点）
        FindPath(root.left, sum);
        // 在右子树查找（不包括当前节点）
        FindPath(root.right, sum);
        return this.sum;
    }
}
