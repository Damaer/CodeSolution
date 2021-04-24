package com.aphysia.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        ArrayList <ArrayList<Integer>>results = new ArrayList();
        boolean reverse = true;
        if(pRoot!=null){
            nodes.add(pRoot);
            while(!nodes.isEmpty()) {
                ArrayList<Integer> integers = new ArrayList();
                int size = nodes.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodes.poll();
                    if(reverse){
                        integers.add(node.val);
                    }else{
                        integers.add(0,node.val);
                    }
                    if (node.left!=null){
                        nodes.offer(node.left);
                    }
                    if(node.right!=null){
                        nodes.offer(node.right);
                    }
                }
                if(integers.size()!=0){
                    results.add(integers);
                }
                reverse=!reverse;
            }
        }
        return results;
    }
}
