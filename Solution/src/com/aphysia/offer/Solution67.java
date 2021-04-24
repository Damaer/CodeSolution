package com.aphysia.offer;

public class Solution67 {
    public static void main(String[] args) {
        System.out.println(new Solution67().cutRope(8));
    }
    public int cutRope(int target) {
        if (target <= 1) {
            return target;
        }
        int[] nums = new int[target + 1];
        nums[1] = 1;
        nums[0] = 1;
        for (int i = 2; i <= target; i++) {
            int max = i;
            for(int j=0;j<=i/2;j++){
                int temp = nums[j]*nums[i-j];
                if(temp>max){
                    max = temp;
                }
            }
            nums[i]=max;
        }
        return nums[target];
    }
}
