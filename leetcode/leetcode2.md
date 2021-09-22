给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

> 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
> 输出：7 -> 0 -> 8
> 原因：342 + 465 = 807

思路：三种情况需要循环，也就是只要有一个数字还有更高位或者有进位的时候，在这里面需要一个变量来保存进位，没有进位的时候，该变量置为0；

代码如下：

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head =result;
        // 定义临时变量表示进位数
        int temp =0;
        while(l1!=null || l2!=null || temp!=0){
            // 两个数的当前位相加，加上之前的进位
            int sum =(l1!=null?l1.val:0)+(l2!=null?l2.val:0)+temp;
            // 再次进位
            temp=sum/10;
            // 余数就是相加后的当前位
            head.next = new ListNode(sum%10);
            // 指针指向下一位
            head = head.next;
            // 如果为null了，那么一直保持为null即可，.next()会导致空指针
            l1 = (l1!=null)?l1.next:l1;
            l2= (l2!=null)?l2.next:l2;
        }
        return result.next;
    }
}
```