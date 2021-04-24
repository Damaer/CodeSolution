# 67.剪绳子

## 题目描述
给你一根长度为`n`的绳子，请把绳子剪成整数长的`m`段（`m`、`n`都是整数，`n>1`并且`m>1`，`m<=n`），每段绳子的长度记为`k[1],...,k[m]``。请问`k[1]x...xk[m]`可能的最大乘积是多少？例如，当绳子的长度是`8`时，我们把它剪成长度分别为`2`、`3`、`3`的三段，此时得到的最大乘积是`18`。

**输入描述:**
> 输入一个数n，意义见题面。``（2 <= n <= 60）``  

**返回值描述:**

**输出答案。**

**示例1**

**输入**
> 8

**返回值**
> 18

## 思路 & 解答
本题的解答思路就是每个长度的绳子，要么最长的情况是不剪开（长度是本身），要么长度是剪开两段的乘积。因此每个长度`length`都需要遍历两个相加之后等于`length`的乘积，取最大值。

初始化值长度为`1`的值为`1`，从长度为`2`开始，每一种长度都需要遍历两个子长度的乘积。

```java
public class Solution {
    public int cutRope(int target) {
        if (target <= 1) {
            return target;
        }
        int[] nums = new int[target + 1];
        nums[1] = 1;
        nums[0] = 1;
        for (int i = 2; i <= target; i++) {
            int max = i;
            for(int j=0;j<=i/2;j++){
                int temp = nums[j]*nums[i-j];
                if(temp>max){
                    max = temp;
                }
            }
            nums[i]=max;
        }
        return nums[target];
    }
}
```
