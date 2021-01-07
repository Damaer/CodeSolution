[toc]
# 题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

# 思路与解析
这里主要使用了多数投票法，先取第一个数字，出现次数是1，遍历后面的数字，如果相同则加1，如果不同则减1，结果如果为0，则把当前的数字更新，而且次数更新为1。

直到最后，则可以获取到出现次数最多的数字，再次遍历数组，统计该数字出现的次数，如果次数大于长度的一半，则说明是该数字。
```java
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }else{
            int num=array[0];
            int count=1;
            for(int i=1;i<array.length;i++){
                if(array[i]==num){
                    count++;
                }else{
                    count--;
                }
                if(count==0){
                    num=array[i];
                    count=1;
                }
            }
            count=0;
            for(int i=0;i<array.length;i++){
                if(array[i]==num){
                    count++;
                }
            }
            if(count>array.length/2){
                return num;
            }else{
                return 0;
            }
        }
    }
}
```
**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
