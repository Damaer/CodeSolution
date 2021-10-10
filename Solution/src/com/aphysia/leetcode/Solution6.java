package com.aphysia.leetcode;

public class Solution6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int sum = 2 * (numRows - 1);
            int gap = (numRows - i - 1) * 2;
            for (int j = i; j < s.length(); ) {
                if (gap != 0) {
                    stringBuffer.append(s.charAt(j));
                }
                j = j + gap;
                gap = sum - gap;
            }
        }
        return stringBuffer.toString();
    }
}
