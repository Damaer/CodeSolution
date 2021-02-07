package com.aphysia.leetcode;

/**
 * @author wenhaoxu
 * @date 2021/2/7 10:37
 */
public class Solution665 {
    public static void main(String[] args) {

    }

    public boolean checkPossibility(int[] nums) {
        if(nums!=null&&nums.length>=2){
            int count = 0;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]){
                    if(count==1){
                        return false;
                    }
                   if(i>0){
                       if(nums[i+1]>=nums[i-1]){
                           nums[i]=nums[i+1];
                       }else{
                           nums[i+1]=nums[i];
                       }
                   }else{
                       nums[i]=nums[i+1];
                   }
                   count++;
                }
            }
        }
        return true;
    }
}
