@[toc]
# 题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

# 思路与解析
这道题难度在于如何正确地处理边界情况，下面我们使用的是不断缩小矩阵上，下，左，右四个边界的方法。首先定义一个up（上边界为0）,down(下边界为matrix.length - 1)，left（左边界为0），right（右边界为matrix[0].length - 1）。
- 从第一个行第一个开始打印，向左边界遍历到右边界，之后将上边界加上1（因为已经遍历完成上边界一行），判断上边界加上一之后是否大于下边界，如果是则调出。
- 之后执行类型操作，从上到下，从右到左，从下到上。
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzE5MDIwMzI4LnBuZw?x-oss-process=image/format,png)

```java
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> results = new ArrayList();
        if (matrix != null && matrix.length > 0) {
            int left = 0;
            int right = matrix[0].length - 1;
            int up = 0;
            int down = matrix.length - 1;
            int i;
            while (true) {
                for (i = left; i <= right; i++) {
                    results.add(matrix[up][i]);
                }
                if ((++up) > down) {
                    break;
                }
                for (i = up; i <= down; i++) {
                    results.add(matrix[i][right]);
                }
                if (--right < left) {
                    break;
                }
                for(i=right;i>=left;i--){
                    results.add(matrix[down][i]);
                }
                if(--down<up){
                    break;
                }
                for(i=down;i>=up;i--){
                    results.add(matrix[i][left]);
                }
                if(++left>right){
                    break;
                }
            }
        }
        return results;
    }
}
```
注意：(++up) > down代表`up=up+1;up>dowm`两个语句。

**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
