package com.aphysia.offer;

public class Solution66 {
    public static void main(String[] args) {
        System.out.println(new Solution66().movingCount(5,10,10));
    }

    public int movingCount(int threshold, int rows, int cols) {
        if (rows > 0 && cols > 0) {
            boolean[][] visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 如果大于阈值，设置已被访问过
                    visited[i][j] = ((getSum(i) + getSum(j)) > threshold);
                }
            }
            return getNum(visited, 0, 0, 0);
        }
        return 0;
    }

    // 获取可以被访问的个数
    private int getNum(boolean[][] visited, int i, int j, int count) {
        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j]) {
            return count;
        }
        count++;
        visited[i][j] = true;
        count = getNum(visited, i, j + 1, count);
        count = getNum(visited, i, j - 1, count);
        count = getNum(visited, i + 1, j, count);
        count = getNum(visited, i - 1, j, count);
        return count;
    }
    // 计算位数之和
    private int getSum(int num) {
        int result = 0;
        while (num > 0) {
            result = result + num % 10;
            num = num / 10;
        }
        return result;
    }
}
