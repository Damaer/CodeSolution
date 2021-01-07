package com.aphysia.offer.offer31;

public class Solution {
    public static void main(String[] args) {
        int result = NumberOf1Between1AndN_Solution(12);
        System.out.println(result);
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        int level = 1;
        int high = n / 10;
        int low = 0;
        int cur = n % 10;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                sum = sum + high * level;
            } else if (cur == 1) {
                sum = sum + high * level + low + 1;
            } else {
                sum = sum + (high + 1) * level;
            }
            low = cur * level + low;
            level = level * 10;
            cur = high % 10;
            high = high / 10;
        }
        return sum;
    }
}
