# 62.二叉搜索树的第k个结点

## 题目描述
给定一棵二叉搜索树，请找出其中的第`k`小的`TreeNode`结点。

**示例1**  
**输入**  

> {5,3,7,2,4,6,8},3

**返回值** 
> {4}

二叉树的节点的描述如下：
```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
```

## 思路 & 解答
本题的思路主要是使用递归，由于二叉搜索树的每一个节点都比自己的左节点大，比自己的右节点小，那么如果求解第`k`小元素，我们不妨使用`k`不断减小，直到1的时候就是最小的元素。

如果`root`为空，那么直接返回，否则，用`k`减掉左子树的节点数：  
如果结果为`1`，说明当前的`root`节点就是第`k`个节点（左子树有`k-1`个节点）；    
如果结果小于`1`，那么说明左子树的节点大于`k-1`个，第`k`个元素在左子树中，使用左子树进行递归；    
如果结果大于`1`，说明左子树的节点不够`k-1`个，那么第`k`个节点肯定是在右子树中。

那么获取子树节点个数的时候，输入的是`k`，如果节点数大于`k`，结果就是负数，如果节点数小于`k`，结果就是正数。如果根节点为空，则直接返回`k`；否则先处理左子树，然后`k--`（表示减掉自身），然后处理右子树。

代码如下：
```java
public class Solution62 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left  = new TreeNode(2);
        root.left.left.left.left  = new TreeNode(1);
        TreeNode result = new Solution62().KthNode(root,3);
        System.out.println(result);
    }
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot==null){
            return pRoot;
        }else{
            int left = getNum(pRoot.left,k);
            if(left==1){
                return pRoot;
            }else if(left<1){
                return KthNode(pRoot.left,k);
            }else{
                return KthNode(pRoot.right,left-1);
            }
        }
    }
    int getNum(TreeNode root,int k){
        if(root==null){
            return k;
        }
        int left = getNum(root.left,k);
        left--;
        return getNum(root.right,left);
    }
}
```
