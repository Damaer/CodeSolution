## 题目描述

> 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

## 例子
输入一个数组：

> num[ 3 ][ 4 ] = [  
1 , 4 , 6 , 28 ,  
2 , 7 , 32 , 30 ,  
10 , 11 , 67 , 79  
]

需要查找一个数字 32 ，则返回true。

## 思路
可以直接暴力遍历，但是这样的复杂度在最坏的情况是便利完所有的才能获取结果。如果这个数组规模是 `n * m`，那么复杂度就是`O(n*m)`。  
但是我们换一种思路，我们选定左下角的10 (`num[2][0],i=2,j=0`)作为起点，如果大于10 ,那么 i+1 ,如果小于 10 ，则 j+1 ，则下一个查找的数字是 11 ,我们知道 32 仍然比 11 大，则往右找到 67 ，继而 32 比 67 小，我们应该往上找，找到了 32 。  
如果找 28 ，则是最坏的结果，查找知道数组的右上角结束，这样一来，最坏的结果就是`O（n+m）`。

## 代码
```java
public class Solution {
    public boolean Find(int target, int [][] array) {
			int size=array.length;
        	int length=array[0].length;
        	int i,j;
        	for(i=size-1,j=0;i>=0&&i<size&&j>=0&&j<length;){
                if(array[i][j]==target){
                    return true;
                }
                if(array[i][j]<target){
					j++;
                    continue;
                }
                if(array[i][j]>target){
                    i--;
                    continue;
                }
            }
        return false;
    }
}
```