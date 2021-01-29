package com.aphysia.offer;

public class Solution38 {
    public static void main(String[] args) {

    }
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}