package com.aphysia.offer;

public class Solution49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        System.out.println(solution49.StrToInt("+2147483647"));
    }

    public int StrToInt(String str) {
        int result = 0;
        boolean biggerThanZero = true;
        if (str != null && str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '+' && i == 0) {
                    continue;
                } else if (str.charAt(i) == '-' && i == 0) {
                    biggerThanZero = false;
                    continue;
                } else {
                    if (str.charAt(i) - '0' >= 0 && '9' - str.charAt(i) >= 0) {
                        result = result * 10 + (str.charAt(i) - '0');
                    } else {
                        return 0;
                    }
                }
            }
        }
        return biggerThanZero ? result : -result;
    }
}
