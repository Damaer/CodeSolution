@[toc]
# 题目
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

# 思路
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzAxMjM0MzQ3LnBuZw?x-oss-process=image/format,png)
首先我们看上面的图片，首先数据保证了正确性，那么前序的第一个肯定是root节点，也就是1，那么我们需要在中序遍历中找到1的位置，左边就是这个root的左子树，右边就是root的右子树。

我们可以举个栗子：对根节点的左子树进行解析：
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzAxMjM0NTE3LnBuZw?x-oss-process=image/format,png)

对右子树进行解析：
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzAxMjM1MDI1LnBuZw?x-oss-process=image/format,png)

只需要不断递归即可，当边界左边大于右边的时候，则停止

# 代码
```java
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        TreeNode root = constructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length-1);
        return root;
    }

    TreeNode constructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        // 不符合条件直接返回null
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        // 构建根节点
        TreeNode root = new TreeNode(pre[startPre]);
        for (int index = startIn; index <= endIn; index++) {
            if (in[index] == pre[startPre]) {
                // 左子树
                root.left = constructBinaryTree(pre, startPre + 1, startPre + (index - startIn), in, startIn, index - 1);
                // 右子树
                root.right = constructBinaryTree(pre, (index - startIn) + startPre + 1, endPre, in, index + 1, endIn);
                break;
            }
        }
        return root;
    }
}
```
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
