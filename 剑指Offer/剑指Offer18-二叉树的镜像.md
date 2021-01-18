@[toc]
# 题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。
 输入描述:
二叉树的镜像定义：源二叉树 

>    	    8
>    	   /  \
>    	  6   10
>    	 / \  / \
>    	5  7 9 11
>    	镜像二叉树
>    	    8
>    	   /  \
>    	  10   6
>    	 / \  / \
>    	11 9 7   5


# 思路与解答
使用递归，直接将左子树反转，右子树反转，交换即可。值得注意的是，反转后的结果需要先保存，左右两个都反转之后，才能赋值。
```java
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

public static void Mirror(TreeNode root) {
    if (root == null) {
        return;
    } else {
        root = reverse(root);
    }
}

public static TreeNode reverse(TreeNode root) {
    if (root == null) {
        return root;
    } else {
        TreeNode left = reverse(root.right);
        TreeNode right = reverse(root.left);
        root.left = left;
        root.right =right;
        return root;
    }
}
```
那这道题如果不用递归怎么做？
其实我们可以使用栈来完成，先把根节点压进栈，循环判断栈是否为空，不为空则取出第一个元素，交换左右节点，然后将左右节点只要不为null，压进栈即可，循环直到栈为空。
show you the code!!!
``` java
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
```


