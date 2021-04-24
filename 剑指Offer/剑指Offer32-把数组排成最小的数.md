# 32.把数组排成最小的数

## 题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组`{3，32，321}`，则打印出这三个数字能排成的最小数字为`321323`。

**示例1**

**输入**

> [3,32,321]

**返回值**

> "321323"

## 思路 & 解答
这道题要求拼起来的数是最小的数字，其实是一个排序问题，只要理解了这一点，就可以快速解决。
假设有两个字符串`s1=3`，`s2=32`，那`s1+s2=332`,`s2+s1=323`,也就是`s1+s2>s2+s1`。
像上面这种情况，要想拼接起来的数最小，肯定是`s2`在前面，`s1`在后面。

而在数组中，我们要使所有的拼接起来是最小，则需要两两比较，类似排序，把满足`s1+s2>s2+s1`的`s1`放到后面，`s2`放到前面。


而排序算法有很多种，我们直接调用`API`的，如果使用冒泡就是O(n<sup>2</sup>),内置的函数是`O(NlogN)`，最差的时候是O(n<sup>2</sup>)。

代码如下：

```java
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String[] strs = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) 
            strs[i] = String.valueOf(numbers[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
```

当然，要是自己实现排序算法也是完全ok的。

