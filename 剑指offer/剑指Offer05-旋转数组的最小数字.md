@[toc]
# 题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

# 思路
- 直接遍历，当出现后面的数比前面的数小的时候，就是找到了最小的数。
- 使用二分查找，在已经排序过的数组中常用的算法。

# 代码
## 直接遍历
```java
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[0];
        }
        int max = array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            }
            if(array[i]<max){
                return array[i];
            }
        }
        return 0;
    }
}
```
## 二分法
旋转之后的数组其实就是分成两段，比如`{3,4,5,1,2}`,可以看到，3,4,5是递增的，但是5之后1就是比之前的数小的，这样就可以找到最小值1。
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzA1MjIxNzE4LnBuZw?x-oss-process=image/format,png)
- 取出中间元素，和最右边元素比较，如果中间元素大于最右边元素，则证明，最小值存在于中间元素到最右边元素之间的一段。如果中间元素小于最右边元素，则证明，最小值在最左边元素到中间元素之间的一段中。

有一种特殊情况，就是相同元素，这样我们没有办法判断最小的元素位于哪一段，所以只能将右边的边界向左移动，即high--。

```java
public class Solution {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int low = 0, high = array.length - 1;
        while (high - low > 1) {
            int mid = (low + high) / 2;
            if (array[mid] > array[high]) {
                low = mid;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return Math.min(array[low], array[high]);
    }
}
```

**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
