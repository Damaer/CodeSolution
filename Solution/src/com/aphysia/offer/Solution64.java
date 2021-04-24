package com.aphysia.offer;

import java.util.*;

public class Solution64 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(new Solution64().maxInWindows(nums, 3));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> results = new ArrayList<>();
        if (num == null || num.length == 0 || num.length < size || size <= 0) {
            return results;
        }
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!integers.isEmpty() && num[integers.peekLast()] < num[i]
                    || !integers.isEmpty() && i - integers.peekLast() >= size) {
                integers.removeLast();
            }
            integers.addLast(i);
            if (i - integers.peekFirst() >= size) {
                integers.removeFirst();
            }
            if (i >= size - 1) {
                results.add(num[integers.peekFirst()]);
            }
        }
        return results;
    }
}