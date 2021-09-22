package com.aphysia.leetcode;

public class Solution5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome1("babad"));
    }
    /*public String longestPalindrome(String s) {
        int start = -1;
        int maxLen = 0;
        if(s==null||s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        int[] nums = new int[s.length()];
        nums[0] = 1;
        for(int i = 1;i<nums.length;i++){
            int index = i-nums[i-1]-1;
            if(index>=0&&s.charAt(index)==s.charAt(i)){
                nums[i] = nums[i-1]+2;
            }else if(s.charAt(i-1)==s.charAt(i)){
                nums[i] = 2;
            }else{
                nums[i]=1;
            }
            if(nums[i]>maxLen){
                maxLen = nums[i];
                start = i-nums[i]+1;
            }
        }
        return s.substring(start,start+maxLen);
    }*/

    public static String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int len = s.length();
        String s1 = new StringBuffer(s).reverse().toString();
        int[][] nums = new int[len][len];
        int end = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (s1.charAt(i) == s.charAt(j)) {
                    if (i == 0 || j == 0) {
                        nums[i][j] = 1;
                    } else {
                        nums[i][j] = nums[i - 1][j - 1] + 1;
                    }
                }
                if (nums[i][j] > max) {
                    if (len - i - 1 + nums[i][j] - 1 == j) {
                        end = j;
                        max = nums[i][j];
                    }
                }
            }
        }
        return s.substring(end - max + 1, end + 1);
    }

    public static String longestPalindrome3(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (judge(s, i, j) && j - i + 1 > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    // 判断每个子串是不是回文
    public static boolean judge(String source, int start, int end) {
        // 对称轴对比
        while (start <= end) {
            if (source.charAt(start) != source.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 构造字符串
    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret = ret + "#" + s.charAt(i);
        ret = ret + "#$";
        return ret;
    }

    // 马拉车算法
    public String longestPalindrome(String str) {
        String S = preProcess(str);
        int n = S.length();
        // 保存回文串的长度
        int[] P = new int[n];
        // 保存边界最右的回文中心以及右边界
        int center = 0, right = 0;
        // 从第 1 个字符开始
        for (int i = 1; i < n - 1; i++) {
            // 找出i关于前面中心的对称
            int mirror = 2 * center - i;
            if (right > i) {
                // i 在右边界的范围内，看看i的对称点的回文串长度，以及i到右边界的长度，取两个较小的那个
                // 不能溢出之前的边界，否则就得中心拓展
                P[i] = Math.min(right - i, P[mirror]);
            } else {
                // 超过范围了，中心拓展
                P[i] = 0;
            }

            // 中心拓展
            while (S.charAt(i + 1 + P[i]) == S.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 看看新的索引是不是比之前保存的最右边界的回文串还要靠右
            if (i + P[i] > right) {
                // 更新中心
                center = i;
                // 更新右边界
                right = i + P[i];
            }

        }

        // 通过回文长度数组找出最长的回文串
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;
        return str.substring(start, start + maxLen);
    }

}
