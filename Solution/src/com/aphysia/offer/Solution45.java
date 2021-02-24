package com.aphysia.offer;

import java.util.HashSet;

public class Solution45 {

    public boolean IsContinuous(int [] numbers) {
        if(numbers==null||numbers.length<5){
            return false;
        }
        HashSet<Integer>set = new HashSet<>();
        int min = 14;
        int max = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]!=0){
                if(set.contains(numbers[i])){
                    return false;
                }
                set.add(numbers[i]);
                max= Math.max(max,numbers[i]);
                min = Math.min(min,numbers[i]);
            }
        }
        return max-min<5;
    }
}
