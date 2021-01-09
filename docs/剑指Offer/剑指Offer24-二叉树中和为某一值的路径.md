@[toc]
# 题目描述
输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

# 思路以及解答
主要是借助队列，将遍历的节点放进队列中，到叶子节点之后计算和，然后再回溯到上面一层的时候，将队列最后一个元素取出来，放进当前的元素。

```java
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
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
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int sum = 0;
        if (root != null) {
            addDatas(root, target, results, queue, sum);
        }
        return results;
    }

    public void addDatas(TreeNode root, int target, ArrayList<ArrayList<Integer>> results, LinkedList<Integer> queue, Integer sum) {
        if (root != null) {
            sum = sum + root.val;
            queue.add(root.val);
            if (sum == target && root.left == null && root.right == null) {
                addResult(results, queue);
            } else {
                addDatas(root.left, target, results, queue, sum);
                addDatas(root.right, target, results, queue, sum);
            }
            queue.pollLast();
            sum = sum - root.val;
        }
    }

    public void addResult(ArrayList<ArrayList<Integer>> results, Queue<Integer> queue) {
        ArrayList<Integer> result = (ArrayList<Integer>) queue.stream().collect(Collectors.toList());
        results.add(result);
    }
}
```

