@[toc]
# 题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

# 思路与解答
用空间换时间做法，就是新建一个数组，copy一份，先计算出奇数的个数，也就是能够知道第一个偶数应该放在数组的哪一个位置，然后再遍历一次，依次放到对应的位置即可。
```java
public class Solution {
    public void reOrderArray(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int x : nums)
            if (x % 2 == 1)
                oddCnt++;
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1)
                nums[i++] = num;
            else
                nums[j++] = num;
        }
    }
}
```

第二种做法，时间复杂度为O(n^2),类似冒泡，将找到的奇数不断往前面冒泡，直到前面排好奇数的位置。
```java
public class Solution {
    public void reOrderArray(int [] array) {
        // 已经摆好的奇数个数
        int numOfOdd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                // 往前面冒泡
                while (j > numOfOdd) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                numOfOdd++;
            }
        }
    }
}
```
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
