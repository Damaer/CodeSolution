package com.aphysia.offer;

import java.util.HashMap;
import java.util.Map;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution40 {
    // 方法1，使用hashmap实现
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> maps = new HashMap<>();
        if (array != null) {
            for (int n : array) {
                Integer num = maps.get(n);
                if (num == null) {
                    maps.put(n, 1);
                } else {
                    maps.put(n, num + 1);
                }
            }
        }
        int index = 1;
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            if (entry.getValue() == 1) {
                if (index == 1) {
                    num1[0] = entry.getKey();
                    index++;
                } else {
                    num2[0] = entry.getKey();
                    return;
                }
            }
        }
    }

    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {
        // A和B异或的结果
        int res = 0;
        for (int val : array) {
            res ^= val;
        }
        // temp保存了两个数最后一个不同的位
        int temp = res & (-res);
        // 保存和最后一个不同的位异或的结果
        int res1 = 0;
        for (int val : array) {
            // 不等于0说明可能是其中一个数，至少排除了另外一个数
            if ((temp & val) != 0) {
                res1 ^= val;
            }
        }
        // 由于其他满足条件的数字都出现两次，所以结果肯定就是只出现一次的数
        num1[0] = res1;
        // 求出另外一个数
        num2[0] = res ^ res1;
    }

}
