package com.aphysia.offer;

import java.util.*;


public class Solution50 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate(int[] numbers) {
        // write code here
        if(numbers!=null) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < numbers.length; i++) {
                if (set.contains(numbers[i])) {
                    return numbers[i];
                } else {
                    set.add(numbers[i]);
                }
            }
        }
        return -1;
    }
}

