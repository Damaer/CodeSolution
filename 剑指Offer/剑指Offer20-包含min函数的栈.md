# 20.包含min函数的栈
## 题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的`min`函数（时间复杂度应为`O（1）`）。

## 思路 & 解答
主要是两个栈，一个存储所有元素的`datas stack`，一个存储最小值 `mins stack`。

`push`一个元素的时候，都需要`push`进`datas stack`,但是`push`进入`mins stack`需要满足条件：当前的`mins stack`是空的，直接放入。或者当前的`mins stack`的栈顶元素大于或者等于`push`进来的值。

`pop`一个元素的时候，如果栈为空则什么都不操作，如果栈不为空，则判断`datas`的第一个元素是否和`mins`的第一个元素相等。如果相等的话那么就需要将`mins`和`datas` `pop`出去第一个元素，否则只需要将`datas`的第一个元素`pop`出去即可。

实现代码如下：

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

