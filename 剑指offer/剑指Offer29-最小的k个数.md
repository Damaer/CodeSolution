[toc]
# 题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

# 思路与解析
下面方法的思路比较简单，但是比较取巧，直接借助了大顶堆，也就是上面的元素是最大的。如果里面个数超过k的话，则弹出堆顶的元素。
这里不展开最大堆和最小堆的具体讲解，什么是最大堆/最小堆呢？
- 大/小堆树是完全二叉树
- 大/小堆树的每一个节点不小于/不大于其孩子节点。

这道题我们用的是最大堆，也就是最上面的元素是最大的，如果个数超过k的话，那么就把堆顶的元素弹出去，也就是优先将最大的弹出。

```java
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || k > input.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : input) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return new ArrayList<>(priorityQueue);
    }
}
```
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
