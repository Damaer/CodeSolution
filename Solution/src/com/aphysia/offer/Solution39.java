package com.aphysia.offer;

import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Body1_1Impl;

import javax.sound.midi.Soundbank;

/**
 * @author wenhaoxu
 * @date 2021/1/29 14:48
 */
public class Solution39 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("123");
        StringBuffer stringBuffer1 = new StringBuffer("456");
        swap(stringBuffer,stringBuffer1);
        System.out.println(stringBuffer);
        System.out.println(stringBuffer1);

        /*TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left =new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        Solution38 solution38 = new Solution38();
        boolean result = solution38.IsBalanced_Solution(treeNode);
        System.out.println(result);*/
    }

    public static void swap(StringBuffer b1,StringBuffer b2){
        StringBuffer stringBuffer = b1;
        b1=b2;
        b2=stringBuffer;
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
