package com.aphysia.offer;

import java.util.LinkedList;
import java.util.List;

public class Solution58 {
    public boolean jude(TreeNode left, TreeNode right) {
        // 如果左右两个都为空，则对称
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            // 如果左右两个有一个为空，那么就不对称
            return false;
        }
        // 都不为空的情况，需要判断两个的值，是不是相等
        if (left.val != right.val) {
            return false;
        } else {
            // 递归判断，左子树的左子树和右子树的右子树，左子树的右子树和右子树的左子树
            return jude(left.left, right.right) && jude(left.right, right.left);
        }
    }

    public boolean isSymmetrical1(TreeNode pRoot) {
        // 判断根节点是否为空，如果不为空则判断左右子树
        return pRoot==null || jude(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;
        LinkedList<TreeNode> leftNodes = new LinkedList<>();
        LinkedList<TreeNode> rightNodes = new LinkedList<>();
        leftNodes.add(pRoot.left);
        rightNodes.add(pRoot.right);
        while (!leftNodes.isEmpty() && !rightNodes.isEmpty()) {
            TreeNode leftNode = leftNodes.poll();
            TreeNode rightNode = rightNodes.poll();
            if (leftNode == null && rightNode == null)
                continue;
            if (leftNode == null || rightNode == null)
                return false;
            // 取出来对比
            if (leftNode.val != rightNode.val)
                return false;
            // 从左往右添加节点
            leftNodes.add(leftNode.left);
            leftNodes.add(leftNode.right);
            // 从右往左添加节点
            rightNodes.add(rightNode.right);
            rightNodes.add(rightNode.left);
        }
        return leftNodes.isEmpty() && rightNodes.isEmpty();
    }
}
