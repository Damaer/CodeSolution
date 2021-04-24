# 46.圆圈中最后剩下的士兵

## 题目描述
约瑟夫问题，是经典的问题，假设有`n`个士兵围着成为一圈，他们的号码是从`0`到`n-1`，那么从第一个开始报数，第一个报数`0`，每次加`1`，报到`n-1`的时候，报`n-1`的士兵出圈，下一个士兵接着从`0`开始报数，这样循环，值得最后，剩下一个士兵，那这个士兵就是胜利者。

现在给出士兵数量`m`，和报数`n`，求解最后胜利的是几号士兵？

**示例**

**输入**
> 5,3

**输出**
> 2

## 思路 & 解答

这道题，由于是围成一个圆圈，涉及到不断删除士兵（出圈）的问题，所以用链表比较适合。判断如果`n`，或者`m`小于等于`0`，非法情况直接返回`-1`。

先把`0`到`n-1`添加到`list`中，初始化计数器`count`为`-1`，索引位置为`-1`，返回的元素值为`0`，循环下面的计数，直到元素全部被删除。

为什么全部删除？这样我们可以直接取最后一个出圈的，也是最后一个待在圈子里面的。

每次计数器和索引位置都加`1`，然后索引位置如果超过了当前剩下的人数，就需要将索引`index`设置到开头位置。如果计数刚好等于`m-1`，那么就移除该索引的元素，并且保存被移除的元素值。同时将计数器`count`设置为`-1`，将索引位置退一位，因为已经把当前位置删除了。

代码实现如下：
```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        System.out.println(solution46.LastRemaining_Solution(5,3));
    }
    public int LastRemaining_Solution(int n, int m) {
        if(n<=0||m<=0){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        int count = -1;
        int index = -1;
        int result = 0;
        while(!list.isEmpty()){
            count++;
            index++;
            if(index>=list.size()){
                index=0;
            }
            if(count==m-1){
                result = list.remove(index);
                count=-1;
                index--;
            }
        }
        return result;
    }
}
```

上面的做法，时间复杂度是`O(N^2)`, 每次删除一个节点，需要先找到那个节点，然后再删除，查找的时间复杂度为`O(N)`,空间上，借助了一个队列，空间复杂度是`O(N)`。


第二种方法，是根据数学归纳法，分析每次被删除的数字规律，直接计算出最后的数字，不需要模拟：

```txt
F(N,M) = ( F(N−1,M) + M ) % N
```
代码实现：
```java
public class Solution {

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % n;
        }
        return result;
    }
}
```


