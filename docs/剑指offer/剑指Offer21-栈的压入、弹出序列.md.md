[toc]
# 题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

# 思路以及解析
主要是模拟这个过程，先把压栈的挨个压入栈中，每压入一个，则找弹出顺序队列的当前元素是否与栈顶元素相等，相等则弹出。直到最后数据应该是空的，则表明两个顺序是对应的。

```java
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        int popIndex = 0;
        Stack<Integer> datas = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            datas.push(pushA[i]);
            while (popIndex < popA.length
                    && !datas.isEmpty()
                    && popA[popIndex] == datas.peek()) {
                datas.pop();
                popIndex++;
            }
        }
        return datas.isEmpty();
    }
}
```
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
