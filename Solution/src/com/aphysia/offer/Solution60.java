package com.aphysia.offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if (pRoot != null) {
            nodes.add(pRoot);
            while (!nodes.isEmpty()) {
                ArrayList<Integer> integers = new ArrayList<>();
                int size = nodes.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodes.poll();
                    integers.add(node.val);
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
                if (!integers.isEmpty()) {
                    results.add(integers);
                }
            }
        }
        return results;
    }
}
