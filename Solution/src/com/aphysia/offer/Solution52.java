package com.aphysia.offer;

import java.util.*;


public class Solution52 {


    public boolean match(String str, String pattern) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        int n = str.length() + 1;
        int m = pattern.length() + 1;
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;
        for (int j = 2; j < m; j = j + 2) {
            if (dp[0][j - 2] && pattern.charAt(j - 1) == '*') {
                dp[0][j] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2]
                            || dp[i - 1][j] && (str.charAt(i - 1) == pattern.charAt(j - 2)
                            || pattern.charAt(j - 2) == '.');
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (str.charAt(i - 1) == pattern.charAt(j - 1)
                            || pattern.charAt(j - 1) == '.');
                }

            }
        }
        return dp[n - 1][m - 1];
    }
    /*public boolean match(String str, String pattern) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        // 第二个字符是'*'
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            // 匹配0次，直接把'*'去掉，两者判断
            return match(str, pattern.substring(2))
                    // 第一个字符相同的时候，去掉第一个字符，判断后面的（相当于匹配多次）
                    || (str.length() > 0 && firstSame(str, pattern)) && match(str.substring(1), pattern);
        } else {
            // 第二个字符不是 '*'的时候，判断第1个字符是否相同，相同的时候再从第2位开始比较
            return str.length() > 0
                    && firstSame(str, pattern)
                    && (match(str.substring(1), pattern.substring(1)));
        }
    }

    // 判断第一个字符是不是相同
    private boolean firstSame(String s, String p) {
        // 两个相同，或者有一个是"."
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }*/
}