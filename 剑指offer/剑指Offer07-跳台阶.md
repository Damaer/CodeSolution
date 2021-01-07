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
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
