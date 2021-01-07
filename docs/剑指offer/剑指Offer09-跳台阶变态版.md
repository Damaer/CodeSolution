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

**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
