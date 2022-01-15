package com.aphysia.offer.v2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution34 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int sum = 0;
        if (root != null) {
            addDatas(root, target, results, queue, sum);
        }
        return results;
    }

    public void addDatas(TreeNode root, int target, ArrayList<ArrayList<Integer>> results, LinkedList<Integer> queue, Integer sum) {
        if (root != null) {
            sum = sum + root.val;
            queue.add(root.val);
            if (sum == target && root.left == null && root.right == null) {
                addResult(results, queue);
            } else {
                addDatas(root.left, target, results, queue, sum);
                addDatas(root.right, target, results, queue, sum);
            }
            queue.pollLast();
            sum = sum - root.val;
        }
    }

    public void addResult(ArrayList<ArrayList<Integer>> results, Queue<Integer> queue) {
        ArrayList<Integer> result = (ArrayList<Integer>) queue.stream().collect(Collectors.toList());
        results.add(result);
    }
}
