# 题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

# 思路
先找到相同的根节点，然后递归判断左子树和右子树即可。
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
