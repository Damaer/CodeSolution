package com.aphysia.offer.v2;

public class Solution44 {
    public int findNthDigit (int n) {
        if (n <= 0) return 0;
        // 开始数值
        long start = 1;
        // 位数
        long digit = 1;
        // 个数
        long count = 9;

        while (n > count) {
            n -= count;
            start *= 10;
            digit += 1;
            count = start * 9 * digit;
        }
        // 所在的数字
        String num = (start + (n - 1) / digit) + "";
        // 计算位数（第几个数字）
        int index = (int)((n - 1) % digit);
        return Integer.parseInt(num.charAt(index) + "");
    }
}
