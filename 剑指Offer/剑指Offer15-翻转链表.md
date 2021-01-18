@[toc]
# 题目描述
输入一个链表，反转链表后，输出新链表的表头。

# 思路与解答
首先，使用循环解答，不断把指向下一个的指针，指向前面的。假设链表是1->2->3->4，那么执行一次循环里面的内容的图示如下：
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzEzMjIwNTQ4LnBuZw?x-oss-process=image/format,png)
直到head==null的时候，返回first即可。
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


还有一种方法，是头插法，也就是先初始化一个listNode,初始化为0->null；然后遍历链表，不断将元素插入到0的后面。假设链表是1->2->3->4.
0->1->null
0->2->1->null
0->3->2->1->null
0->4->3->2->1->null
然后取出listnode.next即可。
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

