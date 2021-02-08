package com.aphysia.offer;

import java.util.List;

/**
 * @date 2021/2/5 16:31
 * @Description TODO
 * @version 1.0
 */
public class Solution62 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left  = new TreeNode(2);
        root.left.left.left.left  = new TreeNode(1);
        TreeNode result = new Solution62().KthNode(root,3);
        System.out.println(result);
    }
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot==null){
            return pRoot;
        }else{
            int left = getNum(pRoot.left,k);
            if(left==1){
                return pRoot;
            }else if(left<1){
                return KthNode(pRoot.left,k);
            }else{
                return KthNode(pRoot.right,left-1);
            }
        }
    }
    int getNum(TreeNode root,int k){
        if(root==null){
            return k;
        }
        int left = getNum(root.left,k);
        left--;
        return getNum(root.right,left);
    }
}

