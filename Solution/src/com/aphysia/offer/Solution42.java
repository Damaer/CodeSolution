package com.aphysia.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// 和为S的两个数字
public class Solution42 {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        System.out.println(new Solution42().FindNumbersWithSum1(array, 15));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> results = new ArrayList<>();
        long mutip = 999999999;
        if (array != null && array.length > 2) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] + array[j] == sum && array[i] * array[j] < mutip) {
                        results.clear();
                        results.add(array[i]);
                        results.add(array[j]);
                        mutip = array[i] * array[j];
                    } else if (array[i] + array[j] > sum) {
                        break;
                    }
                }
            }
        }
        return results;
    }

    public ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        ArrayList<Integer> results = new ArrayList<>();
        long mutip = 999999999;
        HashSet<Integer> set = new HashSet<>();
        if (array != null && array.length > 2) {
            for (int i = 0; i < array.length; i++) {
                if (set.contains(sum - array[i]) && array[i]*(sum - array[i]) < mutip) {
                    results.clear();
                    results.add(sum-array[i]);
                    results.add(array[i]);
                    mutip = array[i] * (sum - array[i]);
                }
                set.add(array[i]);
            }
        }
        return results;
    }

    public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        ArrayList<Integer> results = new ArrayList<>();
        long mutip = 999999999;
        if (array != null && array.length > 2) {
           int left = 0,right = array.length-1;
           while(left<right){
               if(array[left]+array[right]==sum){
                   if(array[left]*array[right]<mutip){
                       mutip = array[left]*array[right];
                       results.clear();
                       results.add(array[left]);
                       results.add(array[right]);
                   }
                   left++;
                   right--;
               }else if(array[left]+array[right]>sum){
                   right--;
               }else{
                   left++;
               }
           }
        }
        return results;
    }
}
