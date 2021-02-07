package com.aphysia.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenhaoxu
 * @date 2021/2/1 21:54
 */
public class Solution41 {

    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        System.out.println(solution41.FindContinuousSequence(9));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results= new ArrayList<>();
        for(int start = 1;start<=sum/2;start++){
            int tempSum = 0;
            ArrayList<Integer> integers = new ArrayList<>();
            for (int j=start;j<sum;j++){
                integers.add(j);
                tempSum = tempSum+j;
                if(tempSum==sum){
                    results.add(integers);
                    break;
                }else if(tempSum>sum){
                    break;
                }
            }
        }
        return results;
    }
}
