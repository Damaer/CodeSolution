package com.aphysia.offer;

public class Solution30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max = array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    public int simpleSolution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int tempSum = 0;
            for (int j = i; j < array.length; j++) {
                tempSum = tempSum + array[j];
                if (tempSum > result) {
                    result = tempSum;
                }
            }
        }
        return result;
    }
}