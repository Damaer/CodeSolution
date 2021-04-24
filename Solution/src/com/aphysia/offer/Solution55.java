package com.aphysia.offer;

import java.util.HashSet;

public class Solution55 {
    public static void main(String[] args) {

    }

    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        HashSet set = new HashSet();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            } else {
                set.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;
    }

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
}
