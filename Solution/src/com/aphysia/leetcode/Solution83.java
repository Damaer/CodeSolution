package com.aphysia.leetcode;

public class Solution83 {
    //计算a^n次方的结果
    long pow(long a, long n) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) ans = (ans * a) % 998244353;
            a = (a * a) % 998244353;
            // 自身乘以自身，快速计算
            n /= 2;
        }
        return ans;
    }

    public long cutRope(long number) {
        if (number == 2) return 1;
        if (number == 3) return 2;

        if (number % 3 == 0) {
            return pow(3, number / 3);
        } else if (number % 3 == 1) {
            return 4 * pow(3, (number - 4) / 3) % 998244353;
        } else {
            return (2 * pow(3, (number - 2) / 3)) % 998244353;
        }
    }
}
