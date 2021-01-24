package com.aphysia.offer;

public class Solution35 {
    public static void main(String[] args) {
        int[] nums = {8, 6, 4, 2, 7, 5, 3, 1};
        Solution35 solution35 = new Solution35();
        int result = solution35.InversePairs(nums);
        System.out.println(result);
    }

    public int InversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int[] nums = new int[array.length];
        return getNums(array, nums, 0, array.length - 1) % 1000000007;
    }

    public int getNums(int[] array, int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftNum = getNums(array, nums, left, mid) % 1000000007;
        int rightNum = getNums(array, nums, mid + 1, right) % 1000000007;
        return leftNum + rightNum + mergeNum(array, nums, left, mid, right);
    }

    public int mergeNum(int[] array, int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            nums[i] = array[i];
        }
        int count = 0;
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                array[k] = nums[j];
                j++;
            } else if (j == right + 1) {
                array[k] = nums[i];
                i++;
            } else if (nums[i] <= nums[j]) {
                array[k] = nums[i];
                i++;
            } else {
                array[k] = nums[j];
                j++;
                count = (count + (mid - i + 1)) % 1000000007;
            }
        }
        return count % 1000000007;
    }
}
