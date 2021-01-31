package com.aphysia.offer;

import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Body1_1Impl;

import javax.sound.midi.Soundbank;

/**
 * @author wenhaoxu
 * @date 2021/1/29 14:48
 */
public class Solution39 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left =new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        Solution39 solution39 = new Solution39();
        boolean result = solution39.IsBalanced_Solution(treeNode);
        System.out.println(result);
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root != null) {
            int left = deep(root.left);
            int right = deep(root.right);
            if (Math.abs(left - right) > 1) {
                return false;
            } else {
                return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
            }
        }
        return true;
    }

    public int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(deep(node.left), deep(node.right)) + 1;
    }
}

class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
