@[toc]
# 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

# 思路及解法

使用递归即可,首先第0级台阶是0次，第1级台阶是1次，跳上第二级台阶可以选择从0直接跳到2，也可以从1跳到2。其他情况，我们可以归纳出，要想跳到n级台阶，最后一步有两种跳法，一种是从n-1级一次跳一级，一种是从n-2级一次跳两级。

$$f(n)=\begin{cases}
0,n=0\\
1,n=1\\
2,n=2\\
f(n-1)+f(n-2),n>2
\end{cases}
$$

```java
public class Solution {
    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }
}
```

但是这样会需要多次重复计算，我们可以利用数组将前面的结果存起来，计算的时候直接取出。

```java
public class Solution {
    public int JumpFloor(int target) {
        int[] nums = new int[target + 1];
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= target; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[target];
    }
}
```

