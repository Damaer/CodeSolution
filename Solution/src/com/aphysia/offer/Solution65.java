package com.aphysia.offer;

public class Solution65 {
    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        Solution65 solution65 = new Solution65();
        System.out.println(solution65.hasPath(matrix, "see"));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix char字符型二维数组
     * @param word   string字符串
     * @return bool布尔型
     */
    public boolean hasPath(char[][] matrix, String word) {
        // write code here
        if (matrix == null || word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                boolean[][] flags = new boolean[matrix.length][matrix[0].length];
                boolean result = judge(i, j, matrix, flags, word, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean judge(int i, int j, char[][] matrix, boolean[][] flags, String words, int index) {
        if (index >= words.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || flags[i][j]) {
            return false;
        }
        System.out.println(words.charAt(index));
        flags[i][j] = true;
        if (matrix[i][j] == words.charAt(index)) {
            if (judge(i - 1, j, matrix, flags, words, index + 1)
                    || judge(i + 1, j, matrix, flags, words, index + 1)
                    || judge(i, j + 1, matrix, flags, words, index + 1)
                    || judge(i, j - 1, matrix, flags, words, index + 1)) {
                return true;
            } else {
                flags[i][j] = false;
                return false;
            }
        } else {
            flags[i][j] = false;
            return false;
        }
    }
}
