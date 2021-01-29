package com.aphysia.offer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 只要有一个为空，就不存在共同节点
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            } else {
                // 如果下一个节点为空，则切换到另一个链表的头节点，否则下一个节点
                head1 = head1.next == null ? pHead2 : head1.next;
                head2 = head2.next == null ? pHead1 : head2.next;
            }
        }
        return null;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        //创建集合set
        Set<ListNode> set = new HashSet<>();

        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            if (set.contains(pHead2))
                return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }

    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        // 只要有一个为空，就不存在共同节点
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        while (head1 != head2) {
            // 如果下一个节点为空，则切换到另一个链表的头节点，否则下一个节点
            head1 = (head1 == null) ? pHead2 : head1.next;
            head2 = (head2 == null) ? pHead1 : head2.next;

        }
        return head1;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
