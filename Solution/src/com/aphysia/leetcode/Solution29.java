package com.aphysia.leetcode;

public class Solution29 {

    public static void main(String[] args) {
        /*System.out.println(divide(1, -1)==-1);
        System.out.println(divide(-1, 1)==-1);
        System.out.println(divide(-1, -1)==1);
        System.out.println(divide(-2147483648, -1)==2147483647);*/
        System.out.println(divide(2147483647, 2) == 1073741823);
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }

        // 是否需要翻转符号
        boolean flag = true;
        if (dividend > 0 && divisor > 0) {
            dividend = -dividend;
            divisor = -divisor;
            flag = false;
        } else if (dividend > 0) {
            dividend = -dividend;
        } else if (divisor > 0) {
            divisor = -divisor;
        } else {
            flag = false;
        }
        int result = 0;
        while (dividend <= divisor) {
            int temp = divisor;
            int num = 1;
            while (dividend < -1 && temp > (dividend >> 1)) {
                if (num > (Integer.MAX_VALUE >> 1)) {
                    break;
                }
                temp = temp + temp;
                num = num << 1;
            }
            if (result > Integer.MAX_VALUE - num) {
                return Integer.MAX_VALUE;
            }
            result = result + num;
            dividend = dividend - temp;
        }
        return flag ? -result : result;
    }
}
