# 55.链表中环的入口节点

## 题目描述

给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出`null`。


给定的链表节点的结构：
```java
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```
## 思路 & 解答

第一种是直接使用`hashSet`,遍历链表的时候，如果`hashSet`中不包含，则添加到`HashSet`中，如果链表中包含，说明已经回到环的第一个节点。代码实现如下：

```java
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet set = new HashSet();
        while(pHead!=null){
            if(set.contains(pHead)){
                return pHead;
            }else{
                set.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;
    }
```

当然，上面的做法时间复杂度为`O(n)`，由于借助了一个`hashSet`，空间复杂度也为`O(n)`。

那假设我们不需要使用额外的空间呢？怎么做呢？

使用快慢双指针，一个一次走一步，一个一次走两步,当两个重合在一起的时候，这时候，并不是环的入口节点。只能说明两个指针，一个比另外一个多走了若干圈，可能是一圈，可能是`2`，`3`圈。

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210319144803.png)

比如上面的，如果开始节点是`A`，环的入口是`B`，相遇的节点是`C`，那么慢指针走的应该是：`S= AB+BC`

快指针走的是：`2S = AB+(BC+CB)*n+BC`，假设多走了n圈

`2(AB+BC) = AB+(BC+CB)*n+BC`

`AB+BC = (BC+CB)*n`

假设`n =1`，那么`AB = CB`,也就是当前位置到环的入口的长度，等于链表头到环的入口的位置。

因此相遇之后，我们讲一个快指针移动到链表头，两个指针每次一步，直到相遇，这个时候，相遇的节点就是换的入口节点。

```java
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode quick = pHead;
        ListNode slow = pHead;
        while (quick != null && slow.next != null) {
            quick = quick.next;
            slow = slow.next.next;
            if (quick == slow) {
                quick = pHead;
                while (quick != slow) {
                    quick = quick.next;
                    slow = slow.next;
                }
                return quick;
            }
        }
        return null;
    }
```


