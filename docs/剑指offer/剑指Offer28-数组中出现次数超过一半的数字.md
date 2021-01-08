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

