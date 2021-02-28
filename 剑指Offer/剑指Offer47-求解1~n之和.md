## 题目描述
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

**示例1**

**输入**
> 5

**返回值**
> 15

## 思路以及解答

这个问题，如果直接使用for循环，超级简单，重拳出击，时间复杂度为O(n)。代码如下：
```java
public class Solution {
    public int Sum_Solution(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
}
```

可是上面的明显违反了使用for循环的原则，再试试公式法，1+2+3+...+(n-1)+n = n*(n+1)/2,代码如下：
```java
public class Solution {
    public int Sum_Solution(int n) {
        if(n>=0){
            return n*(n+1)/2;
        }
        return 0 ;
    }
}
```

但是上面的做法，同样是使用乘法，也违反了原则，那么要不使用循环，也不适用乘法，怎么做呢？

递归！递归可以模拟出循环，几乎所有的for循环操作，都可以以递归的方式实现。每一次递归，我们让n减少1，直到减少为0。代码实现如下：
```java
public class Solution {
    public int Sum_Solution(int n) {
        if(n>=0){
            return n+ Sum_Solution(n-1);
        }
        return 0 ;
    }
}
```
时间复杂度为`O(n)`,空间复杂度也是`O(n)`,因为递归调用需要使用栈，栈里面有栈帧，栈帧里面需要开辟大约`n`个局部变量。