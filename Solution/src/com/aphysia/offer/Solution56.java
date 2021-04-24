package com.aphysia.offer;

import java.util.*;

public class Solution56 {
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        Solution56 solution56 = new Solution56();
        System.out.println(solution56.deleteDuplication(head));
    }
    public ListNode deleteDuplication(ListNode pHead) {
            HashMap<Integer,Integer> maps = new LinkedHashMap<>();
            if (pHead != null) {
                // 遍历添加到set中
                while (pHead != null) {
                    if (!maps.containsKey(pHead.val)) {
                        maps.put(pHead.val,1);
                    }else{
                        maps.put(pHead.val,-1);
                    }
                    pHead = pHead.next;
                }
                ListNode listNode = new ListNode(-1);
                ListNode temp = listNode;
                for (Map.Entry<Integer,Integer> entry: maps.entrySet()) {
                    if(entry.getValue()==1){
                        temp.next = new ListNode(entry.getKey());
                        temp = temp.next;
                    }
                }
                return listNode.next;
            }
            return null;
        }

    public ListNode deleteDuplication1(ListNode pHead) {
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head, cur = pHead;
        while (cur!=null) {
            if (cur.next!=null && cur.val == cur.next.val) {
                cur = cur.next;
                while (cur.next!=null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }
}
