package com.aphysia.offer.v2;

import java.util.HashMap;

public class Solution48 {
    int lengthOfLongestSubstring(String s) {
        int start = -1, len = 1;
        HashMap<Character, Integer> chara = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (chara.containsKey(s.charAt(i))) {

                start = Math.max(start, chara.get(s.charAt(i)));
            }
            chara.put(s.charAt(i), i);

            len = Math.max(len, i - start);
        }
        return len;
    }
}
