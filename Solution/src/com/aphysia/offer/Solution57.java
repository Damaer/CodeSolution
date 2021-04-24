package com.aphysia.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    private static List<TreeLinkNode> treeLinkNodes = new ArrayList<>();

    public class Solution {

        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            // 右节点不为空，直接找右节点的最左子孙节点
            if (pNode.right != null) {
                TreeLinkNode pRight = pNode.right;
                while (pRight.left != null) {
                    pRight = pRight.left;
                }
                return pRight;
            }
            // 右节点为空，但是当前节点是左节点，下一个就是其父节点
            if (pNode.next != null && pNode.next.left == pNode) {
                return pNode.next;
            }
            // 3.右节点为空，并且当前节点是右节点，那只能往上走
            if (pNode.next != null) {
                // 获取父节点
                TreeLinkNode pNext = pNode.next;
                // 判断父节点是不是同样是右节点，如果是，还需要往上走，如果不是，就可以直接放回其
                while (pNext.next != null && pNext.next.right == pNext) {
                    pNext = pNext.next;
                }
                return pNext.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {

    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}