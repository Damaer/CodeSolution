package com.aphysia.leetcode;

public class Solution85 {
    public int[] FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int maxsum = dp[0];
        int left = 0, right = 0;
        int maxLeft = 0, maxRight = 0;

        for (int i = 1; i < array.length; i++) {
            right++;
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            if (dp[i - 1] + array[i] < array[i]) {
                left = right;
            }
            // 更新最大值以及更新最大和的子数组的边界
            if (dp[i] > maxsum
                    || dp[i] == maxsum && (right - left + 1) > (maxRight - maxLeft + 1)) {
                maxsum = dp[i];
                maxLeft = left;
                maxRight = right;
            }
        }
        // 保存结果
        int[] res = new int[maxRight - maxLeft + 1];
        for (int i = maxLeft, j = 0; i <= maxRight; i++, j++) {
            res[j] = array[i];
        }
        return res;
    }
}
