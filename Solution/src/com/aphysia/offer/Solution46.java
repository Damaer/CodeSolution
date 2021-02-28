package com.aphysia.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        System.out.println(solution46.LastRemaining_Solution(5,3));
    }
    public int LastRemaining_Solution(int n, int m) {
        if(n<=0||m<=0){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        int count = -1;
        int index = -1;
        int result = 0;
        while(!list.isEmpty()){
            count++;
            index++;
            if(index>=list.size()){
                index=0;
            }
            //System.out.println(" ");
            // System.out.println(count+" "+index+" ");
            if(count==m-1){
                result = list.remove(index);
               // System.out.print(result+" ");
                count=-1;
                index--;
            }
        }
        return result;
    }
}
