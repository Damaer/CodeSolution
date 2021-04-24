# 66.机器人的运动范围

## 题目描述
地上有一个`m`行和`n`列的方格。一个机器人从坐标`（0,0）`的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当`k`为`18`时，机器人能够进入方格（35,37），因为`3+5+3+7 = 18`。但是，它不能进入方格`（35,38）`，因为`3+5+3+8 = 19`。请问该机器人能够达到多少个格子？


**示例1**

**输入**
> 5,10,10

**返回值**
> 21

## 思路 & 解答

下面使用的主要思路是深度优先搜索算法。首先需要初始化数组，注意是`boolean`类型的二元数组。边初始化边计算位数的和，判断如果大于等于阈值的话，就直接置为`true`，也就是已经被访问到（但是这一部分计入结果）。

然后遍历每一个元素，只要`i`，`j`不在合法的索引范围或者是已经被访问过，都会直接返回`false`。

否则的话，可访问的数量`+1`，并且递归遍历上下左右四个元素，返回最终的可访问的个数。


```java
public class Solution {
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
```

