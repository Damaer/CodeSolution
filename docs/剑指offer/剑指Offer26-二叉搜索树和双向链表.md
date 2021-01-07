# 题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

# 思路以及解答
主要是使用递归，设置一个head和end，head只在第一次设置值，后面就是将end的right指向当前node，将当前node的left指向end，把end指向当前的node。

```java
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public TreeNode head = null;
    public TreeNode end = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        invert(pRootOfTree);
        return head;
    }

    public void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        invert(node.left);
        if (end == null) {
            head = node;
            end =node;
        }else{
            end.right = node;
            node.left = end;
            end =node;
        }
        invert(node.right);
    }
}
```
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
