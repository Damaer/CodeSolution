# 3.从尾到头打印链表
## 题目描述
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。


## 思路以及解法
🙋‍♂️🙋‍♂️首先我们需要想用哪些解法可以解，大概有如下：
- 使用栈 
- 使用递归调用
- 头插法

### 借助栈实现
先把元素里面的元素从头到尾遍历取出放在栈里面，然后再把栈的元素去出来放在`ArraList`里面。主要利用了栈的先进后出的规则，这样就可以实现倒序的功能。`show you the code`：

```java
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> results = new ArrayList<>();
        while (!stack.isEmpty()) {
            results.add(stack.pop()); 
        }
        return results;
    }
}
```

### 递归调用
前面我们能想到栈，那么我们何必自己实现呢？其实方法的调用过程，就是一个天然的栈调用的过程呀，只需要判断当前节点是不是为空，为空则不输出，不为空则递归下一个节点，对下一个节点处理之后，把结果使用`ArrayList.addAll()`加到结果中，再把自身加到结果中，emmmmm有道理，说码就码：
```java
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> results = new ArrayList<>();
        if(listNode!=null){
            // 对后面的元素进行处理
            results.addAll(printListFromTailToHead(listNode.next));
            // 最后添加自身
            results.add(listNode.val);
        }
        return results;
    }
}
```

### 头插法
我们遍历每一个节点，然后把它插入到头部，这样一直遍历到尾的时候，就相当于将整个链表都反转一遍了，然后再从头到尾遍历放到`ArryList`即可。

![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNjMwMjM0NDI4LnBuZw?x-oss-process=image/format,png)

```java
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while(listNode!=null){
            // 先把当前node的next保存起来
            ListNode temp = listNode.next;
            // 把当前节点的next指针指向head的下一个节点
            listNode.next = head.next;
            // 把head的next指向当前节点
            head.next = listNode;
            // 将遍历的指针指向了遍历的下一个元素
            listNode = temp;
        }
        ArrayList<Integer> results = new ArrayList<>();
        head = head.next;
        // 遍历输出
        while(head!=null){
            results.add(head.val);
            head = head.next;
        }
        return results;
    }
}
```

