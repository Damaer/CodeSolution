package com.aphysia.offer.v2;

public class Solution47 {
    public int maxValue(int[][] gifts) {
        int n = gifts.length, m = gifts[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = gifts[i][j];
                if (i - 1 >= 0) {
                    gifts[i][j] = Math.max(gifts[i][j], x + gifts[i - 1][j]);
                }
                if (j - 1 >= 0) {
                    gifts[i][j] = Math.max(gifts[i][j], x + gifts[i][j - 1]);
                }
            }
        }
        return gifts[n - 1][m - 1];
    }
}
