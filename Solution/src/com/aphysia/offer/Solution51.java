package com.aphysia.offer;

public class Solution51 {
    public static void main(String[] args) {

    }


    public int[] multiply1(int[] A) {
        if (A != null) {
            int[] nums = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                int result = 1;
                for (int j = 0; j < A.length; j++) {
                    if (j == i)
                        continue;
                    result *= A[j];
                }
                nums[i] = result;
            }
            return nums;
        }
        return null;
    }

    public int[] multiply(int[] A) {
        if (A == null || A.length < 2)
            return null;
        int[] B = new int[A.length];
        // 初始化第一个值
        B[0] = 1;
        // 计算左边的乘积
        for (int i = 1; i < A.length; i++)
            B[i] = B[i - 1] * A[i - 1];
        // 初始化临时变量
        int temp = 1;
        // 从右边往左边计算
        for (int i = A.length - 2; i >= 0; i--) {
            // 计算右边的乘积
            temp *= A[i + 1];
            // 右边乘以左边
            B[i] *= temp;
        }
        return B;
    }
}
