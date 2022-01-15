package com.aphysia.offer.v2;


class Solution {

    public double[] twoSum(int n) {
        double pre[] = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            double temple[] = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++)
                for (int x = 0; x < 6; x++)
                    temple[j + x] += pre[j] / 6;
            pre = temple;
        }
        return pre;
    }
};

