package com.aphysia.leetcode;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        // next 数组，保存已匹配的字符串的最长公共前后缀
        int next[] = new int[needle.length()];
        getNext(next, needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else j = next[j]; // 模式串上的指针回溯到j位置
        }
        if (j == needle.length()) return (i - j);
        else return -1;
    }

    void getNext(int[] next, String patterns) {
        int j = 0, k = -1;
        next[0] = -1;
        while (j < patterns.length() - 1) {
            if (k == -1 || patterns.charAt(j) == patterns.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else k = next[k]; // 不相等的时候，需要看前面已匹配的字符串的最长公共前后缀，也就是 next[k]
        }
    }


    // 时间超限
    /*public int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }
        for(int i=0;i<haystack.length();i++){
            if(isMatch(haystack,i,needle)){
                return i;
            }
        }
        return -1;
    }

    public boolean isMatch(String haystack,int i, String needle){
        int j=0;
        for(; i<haystack.length() && j<needle.length();i++,j++){
            if(haystack.charAt(i) != needle.charAt(j)){
                return false;
            }
        }
        if(i <= haystack.length()&& j == needle.length()){
            return true;
        }
        return false;
    }*/
}