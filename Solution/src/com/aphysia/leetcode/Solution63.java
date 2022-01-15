package com.aphysia.leetcode;

import java.util.Stack;

public class Solution63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(prices[0]);
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (stack.peek() > prices[i]) {
                stack.pop();
                stack.push(prices[i]);
            } else {
                result = Math.max(result, prices[i] - stack.peek());
            }
        }
        return result;
    }
}
