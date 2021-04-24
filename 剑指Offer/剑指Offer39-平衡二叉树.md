# 39.平衡二叉树

## 题目描述

输入一棵二叉树，判断该二叉树是否是平衡二叉树。
在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。

**示例1**

**输入**
> {1,2,3,4,5,6,7}

**返回值**
> true

## 思路 & 解答

这道题沿用了上一道【树的深度】的思路，何为平衡二叉树，也就是树的左右两个子树的深度相差不超过1，而且同时左右子树也要是平衡二叉树。譬如下面这个就是二叉树：
![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/20210129230930.png)

而这个不是平衡二叉树，**节点3**的左子树深度为`2`，右子树深度为`0`，两个子树的深度相差`2`。而如果单纯从根节点`1`开始，看左右子树的深度的话，就会发现**节点1**左右两个子树的深度相差`1`，是符合平衡二叉树的原则的。这也是为什么我们除了判断根节点的左右子树高度差绝对值相差`1`，还需要分别判断左右两个子树是否也符合平衡二叉树的判定规则。

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/20210129231146.png)


既然要判断整棵树，也要分别判断两个子树，那么想到的肯定就是递归。判断流程大致如下：
- 1. 判断根节点是否为`null`，为`null`直接返回`true`。
- 2. 根节点如果不为`null`，需要求出左子树的高度以及右子树的高度，如果两个相差大于`1`，则返回`false`。
- 3. 如果两个子树的深度相差小于等于`1`，就需要分别判断左，右子树是否为平衡树。也就是以左右两个子节点为根节点，从第1步开始执行。

PS：判断树的深度的分析在上一篇中，有兴趣自己了解一下，也是使用递归，貌似图片东西多了就有点模糊，我的图片都是使用开源软件`draw.io`来画的，我会将源文件都开源在`github`中，画得丑见谅，后续有时间再完善了。

代码如下：
```java
public class Solution39 {
    // 测试代码
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left =new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        Solution39 solution39 = new Solution39();
        boolean result = solution39.IsBalanced_Solution(treeNode);
        System.out.println(result);
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root != null) {
            int left = deep(root.left);
            int right = deep(root.right);
            if (Math.abs(left - right) > 1) {
                return false;
            } else {
                return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
            }
        }
        return true;
    }
    // 求树的深度
    public int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(deep(node.left), deep(node.right)) + 1;
    }
}

class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
```