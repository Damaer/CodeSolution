# 43.左旋转字符串

## 题目描述

汇编语言中有一种移位指令叫做循环左移（`ROL`），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列`S`，请你把其循环左移`K`位后的序列输出。例如，字符序列`S=”abcXYZdef”`,要求输出循环左移3位后的结果，即“`XYZdefabc`”。是不是很简单？OK，搞定它！

**示例1**

> "abcXYZdef",3

**返回值**

> "XYZdefabc"

## 思路 & 解答

这道题目的意思就是将前面`n`位，移动到后面，那么我们可以直接从第`n+1`位开始，遍历到最后一个，再拼接上前面`n`个。

但是值得注意的是，`n`可能大于`str`的长度，那么这种情况下我们应该先对`str`的长度取余，保持严谨。即是：`n = n % str.length();`。

```java
public class Solution {
    public  String LeftRotateString(String str, int n) {
        if (n > str.length()) return str;
        String ret = "";
        n = n % str.length();
        for (int i = n; i < str.length(); ++i) {
            ret += str.charAt(i);
        }
        for (int i = 0; i < n; ++i) {
            ret += str.charAt(i);
        }
        return ret;
    }
}
```
时间复杂度`O(n)`，空间复杂度`O(n)`。

但是如果不想自己写的话，其实我们可以直接调用`api`（不建议这样操作）,代码如下：

```java
    public String LeftRotateString(String str, int n) {
        if (n > str.length()) return str;
        return str.substring(n) + str.substring(0, n);
    }
```

