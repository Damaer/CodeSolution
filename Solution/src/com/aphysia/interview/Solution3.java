package com.aphysia.interview;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
    }

    public static String replaceSpaces(String S, int length) {
        // 字符串的长度
        int size = S.length();
        char[] arrays = new char[size];
        // 这个其实是字符串有效长度最后的一个位置的索引
        int strIndex = length - 1;
        // 从数组后面开始往前面放
        int arraysIndex = size - 1;
        while (strIndex >= 0 && arraysIndex >= 0) {
            // 从有效的长度的最后一个字符开始
            char c = S.charAt(strIndex--);
            // 如果为空格，则替换成%20
            if (c == ' ') {
                arrays[arraysIndex--] = '0';
                arrays[arraysIndex--] = '2';
                arrays[arraysIndex--] = '%';
            } else {
                // 否则保持原字符串
                arrays[arraysIndex--] = c;
            }
        }
        // 结束的时候，可能前面还剩下空位置，截取掉
        return new String(arrays).substring(arraysIndex + 1);
    }
}
