# 17.树的子结构
## 题目描述
输入两棵二叉树`A`，`B`，判断`B`是不是`A`的子结构。（ps：我们约定空树不是任意一个树的子结构）

## 思路 & 解答
先找到相同的根节点，然后递归判断左子树和右子树即可，对于根节点而言，只要有一个为空，就不匹配。如果从根节点开始匹配并且匹配上了，那么就返回true，否则，使用左/右子节点当成根节点匹配。

匹配的过程同样是递归，根节点相同的时候，需要递归判断左子树和右子树。

代码如下：

```java
public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
    // 只要一个为null，则返回false
    if (root1 == null || root2 == null) {
        return false;
    }
    // 从当前根节点比较
    if (sameTree(root1, root2)) {
        return true;
    } else {
        // 否则分别使用左子树或者右子树与root2匹配
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

}

public static boolean sameTree(TreeNode root1, TreeNode root2) {
    // 这里需要注意，当子结构遍历结束的时候，应该返回true
    if ( root2 == null) {
        return true;
    }
    if (root1 != null && root2 != null) {
        if (root1.val == root2.val) {
            return sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
        } else {
            return false;
        }
    }
    return false;
}
```
