@[toc]
# 题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

# 思路以及解法
一共有三种写法，第一种就是下面的，先复制next链路上的节点。然后复制random节点。复制random节点的时候，采取的是遍历的做法。
```java
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node1.random = node3;

        Solution solution = new Solution();
        RandomListNode newNode = solution.Clone(node1);
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode newHead = head;
        RandomListNode oldHead = pHead;
        while (oldHead.next != null) {
            RandomListNode next = new RandomListNode(oldHead.next.label);
            newHead.next = next;

            oldHead = oldHead.next;
            newHead = newHead.next;
        }

        RandomListNode newRandomHead = head;
        RandomListNode oldRandomHead = pHead;
        while (oldRandomHead != null) {
            // 找到第一个节点的随机节点
            RandomListNode randomNode = oldRandomHead.random;
            if (randomNode != null) {
                RandomListNode temp = pHead;
                RandomListNode tempNew = head;
                while (temp != randomNode) {
                    temp = temp.next;
                    tempNew = tempNew.next;
                }
                newRandomHead.random = tempNew;
            }
            oldRandomHead = oldRandomHead.next;
            newRandomHead = newRandomHead.next;
        }
        return head;
    }
}
```
第二种就是上面写法的优化版本，因为我们在复制random的时候，花费了太多时间在查找节点的上面，优化就是用空间换时间，用hashmap存储旧节点和新节点的映射，就可以直接查找对应的random节点。

```java

import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node1.random = node3;

        Solution solution = new Solution();
        RandomListNode newNode = solution.Clone(node1);
        System.out.println(newNode);
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode newHead = head;
        RandomListNode oldHead = pHead;
        HashMap<RandomListNode,RandomListNode>map =new HashMap<>();
        map.put(oldHead,newHead);
        while (oldHead.next != null) {
            RandomListNode next = new RandomListNode(oldHead.next.label);
            newHead.next = next;

            oldHead = oldHead.next;
            newHead = newHead.next;
            map.put(oldHead,newHead);
        }

        RandomListNode newRandomHead = head;
        RandomListNode oldRandomHead = pHead;
        while (oldRandomHead != null) {
            // 找到第一个节点的随机节点
            RandomListNode randomNode = oldRandomHead.random;
            if (randomNode != null) {
                newRandomHead.random = map.get(randomNode);
            }
            oldRandomHead = oldRandomHead.next;
            newRandomHead = newRandomHead.next;
        }
        return head;
    }
}
```

第三种方法就是不需要map，直接在之前的链表上复制，每一个节点都复制一个节点跟在后面，之后再复制random节点。都复制完成之后，将复制的新节点连接起来。
```java
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode oldHead = pHead;
        while (oldHead != null) {
            RandomListNode head = new RandomListNode(oldHead.label);
            RandomListNode temp = oldHead.next;
            oldHead.next = head;
            head.next = temp;
            oldHead = temp;
        }
        RandomListNode randomHead = pHead;
        while (randomHead != null) {
            RandomListNode random = randomHead.random;
            if (random != null) {
                randomHead.next.random = random.next;
            }
            randomHead = randomHead.next.next;
        }

        RandomListNode pCloneHead = pHead.next;
        RandomListNode cur = pHead;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }
```
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
