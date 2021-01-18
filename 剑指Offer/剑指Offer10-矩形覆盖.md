@[toc]
# 题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

比如n=3时，2*3的矩形块有3种覆盖方法：
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzExMTYwMjU1LnBuZw?x-oss-process=image/format,png)

# 思路以及解法

先说思路，基本是递归，首先如果n为1，那么肯定只有一种，f(1)=1,如果n=2，f(2)=2
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzExMTYyMDUyLnBuZw?x-oss-process=image/format,png)

但是n>2的时候呢？那么我们的思路就可以分为第一次切分长度为1，和切分长度为2来计算，也就是剩下的是f(n-1)和f(n-2)，两者加起来即可。
$$f(n)=\begin{cases}
0,n<=0\\
1,n=1\\
2,n=2\\
f(n-1)+f(n-2),n>2
\end{cases}
$$
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzExMTYyNDI5LnBuZw?x-oss-process=image/format,png)

递归写法代码如下：
```java
public class Solution {
    public int RectCover(int target) {
        if(target<=0){
            return 0;
        }else if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else {
            return RectCover(target-1)+RectCover(target-2);
        }
    }
}
```
如果我不想使用递归呢？
那么直接不断地把前面两个数加起来赋值给当前的数字即可。
```java
public class Solution {
    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        } else if (target < 3) {
            return target;
        } else {
            int num1 = 1;
            int num2 = 2;
            int result = 0;
            for (int i = 3; i <= target; i++) {
                result = num1 + num2;
                num1 = num2;
                num2 = result;
            }
            return result;
        }
    }
}
```





