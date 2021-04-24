# 15.翻转链表
## 题目描述
输入一个链表，反转链表后，输出新链表的表头。

## 思路 & 解答
### 循环反向指针
首先，使用循环解答，不断把指向下一个的指针，指向前面的。假设链表是`1->2->3->4`，那么执行一次循环里面的内容的图示如下：

![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzEzMjIwNTQ4LnBuZw?x-oss-process=image/format,png)

直到`head==null`的时候，返回`first`即可。
代码如下：
```java
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return head;
        } else {
            ListNode first = null;
            while (head!= null) {
                ListNode temp = head.next;
                head.next = first;
                first = head;
                head = temp;
            }
            return first;
        }
    }
```

### 头插法
还有一种方法，是头插法，也就是先初始化一个`listNode`,初始化为`0->null`；然后遍历链表，不断将元素插入到0的后面。假设链表是`1->2->3->4.`
```txt
0 -> 1 -> null
0 -> 2 -> 1 -> null
0 -> 3 -> 2 -> 1 -> null
0 -> 4 -> 3 -> 2 -> 1 -> null
```
然后取出`listnode.next`即可。

代码如下：
```java
public ListNode ReverseList(ListNode head) {
    ListNode listnode = new ListNode(1);
    while (head != null) {
        ListNode next = head.next;
        head.next = listnode.next;
        listnode.next = head;
        head = next;
    }
    return listnode.next;
}
```

