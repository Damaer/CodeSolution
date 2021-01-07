@[toc]
# 题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

# 思路以及解答
主要是两个栈，一个存储所有元素的datas stack，一个存储最小值 mins stack。

push一个元素的时候，都需要push进datas stack,但是push进入mins stack需要满足条件：当前的mins stack是空的，直接放入。或者当前的mins stack的栈顶元素大于或者等于push进来的值。

pop一个元素的时候，如果栈为空则什么都不操作，如果栈不为空，则判断datas的第一个元素是否和mins的第一个元素相等。如果相等的话那么就需要将mins和datas pop出去第一个元素，否则只需要将datas的第一个元素pop出去即可。

```java
import java.util.Stack;

public class Solution {

    private Stack<Integer> datas = new Stack<>();
    private Stack<Integer> mins = new Stack<>();


    public void push(int node) {
        datas.push(node);
        if (mins.isEmpty()) {
            mins.push(node);
        } else {
            int min = mins.peek();
            if (node <= min) {
                mins.push(node);
            }
        }
    }

    public void pop() {
        if (datas.isEmpty()) {
            return;
        } else {
            int value = datas.peek();
            if (value == mins.peek()) {
                mins.pop();
            }
            datas.pop();
        }
    }

    public int top() {
        if(datas.isEmpty()){
            return -1;
        }
        return datas.peek();
    }

    public int min() {
        if(mins.isEmpty()){
            return -1;
        }
        return mins.peek();
    }
}
```
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
