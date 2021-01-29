package com.aphysia.offer;

public class Solution37 {
    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        int[] nums = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        solution37.GetNumberOfK(nums, 3);
    }

    public int GetNumberOfK(int[] array, int k) {
        // 数组为空或者数组元素个数为0，直接返回
        if (array == null || array.length == 0) {
            return 0;
        }
        // 使用二分法，找出等于k的数的索引
        int index = findIndex(array, k, 0, array.length - 1);
        // 索引为-1，则说明该数不存在
        if (index == -1) {
            return 0;
        }
        // 存在则index处存在一个
        int count = 1;
        // 向左边拓展，计算相等的个数
        for (int left = index - 1; left >= 0; left--) {
            if (array[left] == k) {
                count++;
            }
        }
        // 向右边拓展，计算相等的个数
        for (int right = index + 1; right < array.length; right++) {
            if (array[right] == k) {
                count++;
            }
        }
        return count;
    }


    public int findIndex(int[] array, int k, int left, int right) {
        // 只剩下一个数，直接和k比较
        if (left == right) {
            return array[left] == k ? left : -1;
        } else {
            // 中间的数索引为mid。将数组分为两半
            int mid = left + (right - left) / 2;
            // 等于k直接返回当前索引
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] < k) {
                // mid索引的数小于k，则k只可能在右边一半
                return findIndex(array, k, mid + 1, right);
            } else {
                // 否则在左边一半
                return findIndex(array, k, left, mid - 1);
            }
        }
    }
}
