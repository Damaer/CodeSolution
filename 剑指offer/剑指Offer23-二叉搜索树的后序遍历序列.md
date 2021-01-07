@[toc]
# 题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

# 思路以及解答
注意是二叉搜索树，如果是后续遍历的话，那么应该最后一个元素是中间元素mid，前面的元素可以分为两部分，一部分比mid小，另一部分全部比mid大。如果破坏这个原则，那么就应该输出No。
```java
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return verifySection(sequence, 0, sequence.length - 1);
    }

    private boolean verifySection(int[] sequence, int strat, int end) {
        if (strat >= end) {
            return true;
        }
        int mid = sequence[end];
        int midIndex = end;
        for (int i = strat; i < end; i++) {
            if (sequence[i] > mid) {
                midIndex = i;
                break;
            }
        }
        for (int i = midIndex; i < end; i++) {
            if (sequence[i] < mid) {
                return false;
            }
        }
        return verifySection(sequence, strat, midIndex - 1) && verifySection(sequence, midIndex, end - 1);
    }
```
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
