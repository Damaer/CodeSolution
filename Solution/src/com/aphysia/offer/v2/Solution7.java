package com.aphysia.offer.v2;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Solution7 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 判空
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int preIndex = 0;
        int inIndex = 0;

        TreeNode root = new TreeNode(pre[preIndex]);
        stack.push(root);

        for (preIndex = 1; preIndex < pre.length; preIndex++) {
            TreeNode node = stack.peek();
            // 不相等说明还有左子树
            if (node.val != in[inIndex]) {
                // 关联成为左子树，压栈
                node.left = new TreeNode(pre[preIndex]);
                stack.push(node.left);
            } else {
                // 相等说明，当前节点没有左子树
                while (!stack.isEmpty() && stack.peek().val == in[inIndex]) {
                    // 只要两者相等，说明没有右子树，弹出节点，退到上一层
                    node = stack.pop();
                    inIndex++;
                }
                // 有右子树，关联
                node.right = new TreeNode(pre[preIndex]);
                stack.push(node.right);
            }
        }
        return root;
    }
}
