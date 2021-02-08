package com.aphysia.offer;

/**
 * @author wenhaoxu
 * @date 2021/2/8 21:20
 * @Description TODO
 * @version 1.0
 */
public class Solution43 {
    public String LeftRotateString(String str, int n) {
        if (n > str.length()) return str;
        String ret = "";
        n = n % str.length();
        for (int i = n; i < str.length(); ++i) {
            ret += str.charAt(i);
        }
        for (int i = 0; i < n; ++i) {
            ret += str.charAt(i);
        }
        return ret;
    }

    public String LeftRotateString1(String str, int n) {
        if (n > str.length()) return str;
        return str.substring(n) + str.substring(0, n);
    }
}
