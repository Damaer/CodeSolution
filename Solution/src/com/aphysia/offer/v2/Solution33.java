package com.aphysia.offer.v2;

import java.util.Arrays;
import java.util.Stack;

public class Solution33 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        int[] inorder = Arrays.copyOf(sequence, sequence.length);
        Arrays.sort(inorder);
        return isPopOrder(inorder, sequence);
    }

    boolean isPopOrder(int[] pushV, int[] popV) {
        int n = pushV.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < n) {
            stack.push(pushV[i]);
            while (!stack.empty() && stack.peek() == popV[j]) {
                ++j;
                stack.pop();
            }
            ++i;
        }
        return j == n;
    }
}
