@[toc]
# 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

# 思路和解法
首先青蛙一次可以跳1,2,3到n级。假设函数是f（n），则：
- 青蛙跳到第一级是f（1）=1，只有一种跳法。
- 青蛙跳到第二级，可以是直接跳到第二级，也可以是从第一级直接跳。所以f(2)=f(1)+1
- 青蛙跳到第三级，可以从第0级跳，也可以从第1级跳，也可以从第2级跳。所以f(3) =f(1)+f(2)+1;
- 依次类推，青蛙跳到第n级，可以是从0,1,2,3..(n-1)级跳，所以f(n)=f(1)+f(2)+f(3)...+f(n-1)+1;

因此我们需要双层for循环即可完成。
```java
public class Solution {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        int[] nums = new int[target];
        nums[0] = 1;
        for (int i = 0; i < target; i++) {
            int sum = 1;
            for (int j = 0; j < i; j++) {
                sum += nums[j];
            }
            nums[i]=sum;
        }
        return nums[target - 1];
    }
}
```

完成之后我们可以顺便推一下公式：
$$
f(n)= f(1)+f(2)+...+f(n-2)+f(n-1)+1;\newline
f(n-1)=f(1)+f(2)+...+f(n-2)+1;\newline
f(n)-f(n-1)=f(n-1);\newline
f(n)=2*f(n-1);\newline
$$

所以最后我们可以推倒出:
$$
f(n) = 2^{n-1}
$$

show you the code:
```java
public class Solution {
    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
```


