@[toc]
# 题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

# 思路以及解析
思路比较清晰，首先创建一个-1节点的新链表，然后两个链表都从头开始，循环到直到一个链表遍历到最后，谁的节点小，就加入新的链表后面。然后遍历两个链表剩下的元素，这些元素肯定比另一个链表的所有元素都大或者相等，直接加入新的链表后面即可。

```java
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list1;
        }else if(list2==null){
            return list2;
        }else{
            ListNode head = new ListNode(-1);
            ListNode first = head;
            while(list1!=null&&list2!=null){
                if(list1.val<list2.val){
                    first.next = new ListNode(list1.val);
                    list1=list1.next;
                }else {
                    first.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                first = first.next;
            }
            while(list1!=null){
                first.next = new ListNode(list1.val);
                list1=list1.next;
                first = first.next;
            }
            while(list2!=null){
                first.next = new ListNode(list2.val);
                list2=list2.next;
                first = first.next;
            }
            return head.next;
        }
    }
```
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
