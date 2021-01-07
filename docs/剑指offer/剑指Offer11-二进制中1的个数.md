@[toc]
# 题目描述
输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。

# 思路以及解法
首先说一个**错误**的解法，很多人可能会想到，那就是不断对2取余数。但是这种做法有个致命的缺陷，那就是忽略了负数，负数使用补码表示的时候，是取反之后加一，而且
```java
public class Solution {
    public int NumberOf1(int n) {
        int num = 0;
        while (n != 0) {
            int tmp = n % 2;
            if (tmp == 1||tmp==-1) ++num;
            n /= 2;
        }
        return num;
    }
}
```
其次就是移位算法，把整数当成二进制，不断向右移位和1进行与计算。利用了所有数和1进行与计算，结果为1则证明最后一位是1。
于是我们代码可以写成这样,但是**这样也是有问题的！！！**：
```java
public class Solution {
    public int NumberOf1(int n) {
        int num=0;
        while (n != 0) {
            if ((n & 1)==1){
                ++num;
            }
            n = n>>1;
        }
        return num;
    }
}
```
上面代码的问题在于忽略了负数右移，其实第一位还是会补1，所以还是负数。就是说-1其实右移动之后还是-1，这样判断是无效的，而且会死循环。
既然输入的n没办法右移，那么我们把1左移是不是就解决这个问题了呢？是的！正确代码如下：
```java
public class Solution {
    public int NumberOf1(int n) {
        int num = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                num++;
            }
            flag <<= 1;
        }
        return num;
    }
}
```

除此之外，还有其他做法么？还有一种做法的不断把最右边的1变成0，那就是利用`n=n&(n-1)`，比如7的二进制是111，那么7&6=111&110=110=6，就完美把最后一位1变成0了，6的二进制是110,6&5=110&101=100=4，也把最后一位1变成了0.

负数可不可以？可以！比如：
32位-7 = 11111111111111111111111111111001 ，
32位-8 = 11111111111111111111111111111000，
-7&-8  = 11111111111111111111111111111000
![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tYXJrZG93bnBpY3R1cmUub3NzLWNuLXFpbmdkYW8uYWxpeXVuY3MuY29tLzIwMjAwNzEyMTQ1MzU4LnBuZw?x-oss-process=image/format,png)
所以这种思路针对负数也是正确的：
```java
public class Solution {
    public int NumberOf1(int n) {
        int num = 0;
        while (n != 0) {
            num++;
            n &= (n - 1);
        }
        return num;
    }
}
```

还有一种思路那就是直接调用java的api把整数，转成字符串，遍历一次获取1的个数,可以但是不提倡，因为本题考查的是位运算，而不是api使用和for循环。
```java
public class Solution {
    public int NumberOf1(int n) {
        int t = 0;
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                t++;
            }
        }
        return t;
    }
}
```

**此文章仅代表自己（本菜鸟）学习积累记录，或者学习笔记，如有侵权，请联系作者删除。人无完人，文章也一样，文笔稚嫩，在下不才，勿喷，如果有错误之处，还望指出，感激不尽~**

**技术之路不在一时，山高水长，纵使缓慢，驰而不息。**

**公众号：秦怀杂货店**

![](https://img-blog.csdnimg.cn/img_convert/7d98fb66172951a2f1266498e004e830.png)
