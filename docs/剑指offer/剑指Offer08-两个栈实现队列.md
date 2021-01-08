@[toc]
# 题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

# 思路和解法
- 栈的特性是先进后出
- 队列的特性是先进先出

有两个栈`stack1`,`stack2`；
如果有新的数据进入，那么我们可以直接push到stack1；
如果需要取出数据，那么我们优先取出`stack2`的数据，如果`stack2`里面数据是空的，那么我们需要把所有的`stack1`的数据倒入`stack2`。再从`stack2`取数据。

例如：
(1). push 1--> push 2
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzExMTEyMjM1LnBuZw?x-oss-process=image/format,png)

(2).pop 1
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzExMTEyNDAxLnBuZw?x-oss-process=image/format,png)

(3). push 3--> push 4
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzExMTEyNDQ2LnBuZw?x-oss-process=image/format,png)

(4).pop 2
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzExMTEyNTE2LnBuZw?x-oss-process=image/format,png)

```java
import java.util.Stack;
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
```


