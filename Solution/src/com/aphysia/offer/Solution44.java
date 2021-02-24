package com.aphysia.offer;

import java.util.Stack;

public class Solution44 {
    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.ReverseSentence("I am a student."));
    }

    public String ReverseSentence(String str) {
        if (str != null && str.length() != 0 && !str.equals("   ")) {
            String[] strs = str.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = strs.length - 1; i >= 0; i--) {
                stringBuilder.append(strs[i]);
                stringBuilder.append(i == 0 ? "" : " ");
            }
            return stringBuilder.toString();
        }
        return str;
    }

    public String ReverseSentence1(String str) {
        if (str == null || str.length() == 0)
            return str;
        StringBuilder stringBuilder = new StringBuilder();
        String[] strs = str.split(" ");
        if (strs.length == 0)
            return str;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length - 1; i++) {
            stack.push(strs[i]);
            stack.push(" ");
        }
        stack.push(strs[strs.length - 1]);
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
