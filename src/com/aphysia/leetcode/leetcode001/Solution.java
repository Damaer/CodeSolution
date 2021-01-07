package com.aphysia.leetcode.leetcode001;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> numSet = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numSet.containsKey(target - nums[i])) {
                result[0] = numSet.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                numSet.put(nums[i], i);
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int []result = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=1;i+j<nums.length;j++){
                if(nums[i]+nums[i+j]==target){
                    result[0]=i;
                    result[1]=i+j;
                }
            }
        }
        return result;
    }
}
