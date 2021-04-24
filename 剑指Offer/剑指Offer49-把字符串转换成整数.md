# 49.把字符串变成整数

## 题目描述

将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回`0`

**输入描述:**  
输入一个字符串,包括数字字母符号,可以为空

**返回值描述:**  
如果是合法的数值表达则返回该数字，否则返回0

**示例1**
**输入**
> "+2147483647"

**返回值**
> 2147483647

**示例2**

**输入**
> "1a33"

**返回值**
> 0

## 思路 & 解答

这道题的思路相对比较直观，首先需要判定输入的字符串是否不为空且有效，否则返回`0`。如果是有效字符串，初始化结果`result`为0，`biggerThanZero`表示是否大于0，默认是`true`，也就是正数。

遍历每一位，如果`i`是`0`，且是“`+`”,说明是符号位，直接`continue`，如果`i`为0，且字符为“`-`”，说明是符号位且为负数，其他的，判断字符是否在`0~9`之间，也就是`str.charAt(i) - '0' >= 0 && '9' - str.charAt(i) >= 0`,如果符合条件，则将之前的`result`乘以`10`，加上当前字符所表示的数字。如果不符合条件，说明是非法的字符串，直接返回即可。


```java
public class Solution49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        System.out.println(solution49.StrToInt("+2147483647"));
    }

    public int StrToInt(String str) {
        int result = 0;
        boolean biggerThanZero = true;
        if (str != null && str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '+' && i == 0) {
                    continue;
                } else if (str.charAt(i) == '-' && i == 0) {
                    biggerThanZero = false;
                    continue;
                } else {
                    if (str.charAt(i) - '0' >= 0 && '9' - str.charAt(i) >= 0) {
                        result = result * 10 + (str.charAt(i) - '0');
                    } else {
                        return 0;
                    }
                }
            }
        }
        return biggerThanZero ? result : -result;
    }
}
```

时间复杂度为`O(n)`，也就是遍历完字符串即可，空间复杂度为`O(1)`。