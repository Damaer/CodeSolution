package com.aphysia.offer.v2;

public class Solution46 {
    public int solve(String nums) {
        int len = nums.length();
        if (len == 0 || nums.charAt(0) == '0')
            return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums.charAt(i) == '0') {
                if (nums.charAt(i - 1) == '1' || nums.charAt(i - 1) == '2') {
                    if (i == 1) {
                        dp[i] = 1;
                    } else {
                        dp[i] = dp[i - 2];
                    }
                }
            } else if (nums.charAt(i - 1) == '1'
                    || (nums.charAt(i - 1) == '2' && nums.charAt(i) >= '1' && nums.charAt(i) <= '6')) {
                if (i == 1) {
                    dp[i] = 2;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }
}
