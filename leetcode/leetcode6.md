## 题目
将一个给定字符串 `s` 根据给定的行数 `numRows` ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "`PAYPALISHIRING`" 行数为 `3` 时，排列如下：
```txt
P   A   H   N
A P L S I I G
Y   I   R
```
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："`PAHNAPLSIIGYIR`"。

请你实现这个将字符串进行指定行数变换的函数：`string convert(string s, int numRows);`

**示例 1：**

- 输入：s = "PAYPALISHIRING", numRows = 3
- 输出："PAHNAPLSIIGYIR"

**示例 2：**

- 输入：s = "PAYPALISHIRING", numRows = 4
- 输出："PINALSIGYAHRPI"

解释：
```txt
P     I    N
A   L S  I G
Y A   H R
P     I
```

**示例 3：**

- 输入：s = "A", numRows = 1
- 输出："A"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 思路以及解答

原来的顺序是 "Z" 字型的，我们用小方块来模拟位置摆放：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20211009233833.png)

现在需要按照每一行来遍历：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20211010012458.png)

那么我们就要先找到里面的规律，首先按照每一行遍历，那么每行有行号，遍历的时候，按照 从第 `0` 行到 第 `row-1` 行(也就是最外层循环)：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20211010013734.png)

那么每一行需要怎么处理呢？

需要我们发现每一行的规律，我们用 `row = 6` ，`i = 3`的行来摸索，也就是 6 行中的第 3行：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20211010014304.png)

【看 `i = 3` 的行】从第一个方块到第二个方块，其实间隔的方块数就是就是下面的红色部分，当前为 第 `i`行，下面还有 `row-1-i` 行，下面的红色方块的数量计算为：
每一行都是两个方块除了最下面一行只有一个，所以是 `行数*2-1` ,即 `(row-1-i)*2-1`,所以从第一个方块到第二个方块，中间间隔了 `方块数 = (row-1-i)*2-1` 个方块，那么只要第一个位置加上 `方块数+1`,就可以得到第二个方块的位置。

```txt
gap = 方块数 + 1 = (row - 1 - i) * 2
```

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20211010015127.png)

下面我们看第 `3` 行，第二个方块到第三个方块，间隔的是上面的红色方块，第 `i` 行上面还有 `i` 行，每一行都有两个方块，除了第一行，所以上面方块数为 `2*i-1`，间隔的 gap：

```txt
gap = 方块数 + 1 = 2 * i
```

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20211010124408.png)

我们接着看第 `3` 行，第三个方块到第四个方块，其实重复了前面的第一个方块到第二个方块的过程：

```txt
gap = 方块数 + 1 = (row - 1 - i) * 2
```

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20211010015839.png)

至此，我们发现了其中的规律，每一行中的间隔是不断循环的过程，每个循环的过程，又分为两个阶段：
```txt
阶段1： gap1 = 方块数 + 1 = (row - 1 - i) * 2
阶段2： gap2 = 方块数 + 1 = 2 * i
```
![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20211010124624.png)

每一行循环的结束条件是：**不能超过字符串长度** ，每个循环里面的两个间隔`gap` 其实用 `flag` 不断变化也是可以的, 但是我们发现它们的和是固定的 `(row - 1) * 2`：

```txt
sum = gap1 + gap2 = (row - 1 - i) * 2 + 2 * i = (row - 1) * 2
```

那就好办，每次用 `sum - gap` 就可以得到下一次的 `gap`。

**特殊情况：**
第一行和第二行，每一个循环中有一个 `gap` 是 `0`, `gap` 为 0 的时候我们不能重复打印该位置的字符：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20211010125812.png)

Java 代码实现:

```Java 
public class Solution6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int sum = 2 * (numRows - 1);
            int gap = (numRows - i - 1) * 2;
            for (int j = i; j < s.length(); ) {
                if (gap != 0) {
                    stringBuffer.append(s.charAt(j));
                }
                j = j + gap;
                gap = sum - gap;
            }
        }
        return stringBuffer.toString();
    }
}
```

C++ 代码实现：

```c++
#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        string str;
        for (int i = 0; i < numRows; i++) {
            int sum = 2 * (numRows - 1);
            int gap = (numRows - i - 1) * 2;
            for (int j = i; j < s.length(); ) {
                if (gap != 0) {
                    str += s[j];
                }
                j = j + gap;
                gap = sum - gap;
            }
        }
        return str;
    }
};
int main(){
    Solution solution;
    string str = "PAYPALISHIRING";
    cout<< solution.convert(str,4)<<endl;
    return 0;
}
```

至于时间复杂度，看似是两层循环，实则不是O(n^2^), 只是遍历完了里面所有的字符，所以为O(n)。

今日总结：

> 算法题有时候就是找规律(苦笑...)
