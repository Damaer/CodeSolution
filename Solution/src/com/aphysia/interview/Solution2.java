package com.aphysia.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (counts[s1.charAt(i) - 'a'] == 0) {
                return false;
            }
            counts[s1.charAt(i) - 'a']--;
        }
        return true;
    }
    /*public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> count1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (count1.get(s1.charAt(i)) != null) {
                count1.put(s1.charAt(i), count1.get(s1.charAt(i)) + 1);
            } else {
                count1.put(s1.charAt(i), 1);
            }
        }
        Map<Character, Integer> count2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            if (count2.get(s2.charAt(i)) != null) {
                count2.put(s2.charAt(i), count1.get(s2.charAt(i)) + 1);
            } else {
                count2.put(s2.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : count1.entrySet()) {
            if (count2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }*/
    /*public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }*/
}
