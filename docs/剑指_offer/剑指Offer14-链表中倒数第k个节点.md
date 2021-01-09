@[toc]
# 题目描述
输入一个链表，输出该链表中倒数第k个结点。

# 思路以及解析
思路比较清晰，那就是前后指针，先让第1个指针先走k步，然后第2个指针开始走，而且两个指针一起走，直到第一个指针走到最后的位置。

```java
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode first = head;
        while (k != 0) {
            if (first == null) {
                return null;
            }
            first = first.next;
            k--;
        }
        while (first!= null) {
            head = head.next;
            first = first.next;
        }
        return head;
    }
}
```

