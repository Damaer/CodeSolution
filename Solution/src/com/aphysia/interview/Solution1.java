package com.aphysia.interview;

import java.util.HashSet;

public class Solution1 {
    /*public boolean isUnique(String astr) {
        if (astr == null) {
            return false;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if (set.contains(astr.charAt(i))) {
                return false;
            } else {
                set.add(astr.charAt(i));
            }
        }
        return true;
    }*/

    public boolean isUnique(String astr) {
        if (astr == null) {
            return false;
        }
        long left = 0;
        long right = 0;
        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long bit = 1L << (c - 64);
                if ((left & bit) != 0) {
                    return false;
                }
                left |= bit;
            } else {
                long bit = 1L << c;
                if ((right & bit) != 0) {
                    return false;
                }
                right |= bit;
            }
        }
        return true;
    }
}
