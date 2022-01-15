package com.aphysia.leetcode;

public class Solution81 {
    public int[] reOrderArrayTwo(int[] array) {
        int low = 0;
        int high = array.length - 1;
        // 直到两个指针相遇
        while (low < high) {
            // 左指针往右查找偶数停下来
            while (array[low] % 2 == 1) ++low;
            // 右指针往左查找奇数停下来
            while (array[high] % 2 == 0) --high;
            if (low < high) {
                // 交换
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
        return array;
    }
}