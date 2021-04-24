# 60.将二叉树打印成多行

## 题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

**示例1**
**输入**
> {8,6,10,5,7,9,11}

**返回值**
> [[8],[6,10],[5,7,9,11]]

## 思路 & 解答

和前面的题差不多，甚至更加简单：
1. 借助双向链表，先将根节点添加进去：

2. 获取`list`里面剩下的元素的个数，挨个取出就是一层，取出的时候，添加到当前层的`list`结果集中，然后判断每一个取出来的节点的左右节点是不是为空，不为空则加入链表。（按照层次遍历的时候需要按照`size`来循环）

3. 每一层处理完之后，将`list`加入结果集中，继续判断`list`是不是为空，执行第二步循环。

```java
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if (pRoot != null) {
            nodes.add(pRoot);
            while (!nodes.isEmpty()) {
                ArrayList<Integer> integers = new ArrayList<>();
                int size = nodes.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodes.poll();
                    integers.add(node.val);
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
                if (!integers.isEmpty()) {
                    results.add(integers);
                }
            }
        }
        return results;
    }
}
```

借助了队列，空间复杂度为`O(n)`，时间复杂度为`O(n)`。


