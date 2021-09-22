## 题目描述
给你一个字符串 s，找到 s 中最长的回文子串。

## 例子

```txt
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"

示例 3：
输入：s = "a"
输出："a"

示例 4：
输入：s = "ac"
输出："a"
```

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring，著作权归领扣网络所有。

## 思路以及解答

### 暴力破解
暴力破解，即是针对里面每一个子串，都去判断是否为回文串。
![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210912143620.png)

判断每一个字符是不是回文串，比如用 `cbac` 判断，左右两个指针，对称判断，相等则往中间移动，继续判断，不相等则直接返回 false 。
![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210912144540.png)

```java
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String result = s.substring(0, 1);
        for (int i=0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (judge(s, i, j) && j - i + 1 > result.length()) {
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }
    
    // 判断每个子串是不是回文
    public static boolean judge(String source, int start, int end) {
        // 对称轴对比
        while (start <= end) {
            if (source.charAt(start) != source.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
```

暴力破解复杂度过高，会超时，不推荐使用。
![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210912144801.png)

### 中心拓展法
回文串总是中心对称的，前面使用暴力法的时候，都是截取出子串之后再判断，只有判断到全部对称，才能证明回文，这样其实走了很多弯路，只要最后一个不对称，前功尽弃。

反过来想，我们不如在每一个点，都尝试往两边拓展，这样只要不匹配，就可以及时止顺。

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210912210151.png)

值得注意的是，中心拓展法的中心怎么找？3个字符有多少个中心呢？

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210912211149.png)

一共有五个中心，有些中心可能是两个字符的间隙，有些中心可能是字符。那么设计的时候，我们用 `left` 和 `right` 表示两个指针：
- `left = right`：对称中心为字符
- `left + 1 = right`: 对称中心为两个字符的间隙

具体实现如下：

```java
class Solution {
    // 开始下标
    public static int start = -1;
    // 最大长度
    public static int maxLen= 0;
    public String longestPalindrome(String s) {
        start = -1;
        maxLen = 0;
        if(s==null||s.length()==0){
            return "";
        }
        for(int i=0;i<s.length();i++){
            // 以当前字符为对称轴
            judge(s,i,i);
            // 以当前字符和下一个字符的间隙为对称轴
            judge(s,i,i+1);
        }
        if(start == -1){
            return "";
        }
        return s.substring(start,start+maxLen);
    }

    public void judge(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        int size =  right-left-1;
        if(size > maxLen){
            maxLen = size;
            start = left+1;
        }
    }
}

```

### 动态规划

其实，一个字符串是回文串的话，那么它倒过来读也是一样的，也就是说，它与它反转后的字符串，其实是完全匹配的，那么要是我们用一个字符串和它反转字符串一一统计匹配，是不是就可以得到结果呢？

答案是肯定的！假设原字符串为 `s1`，反转后的字符串为 `s2`，字符串长度为 `n`，我们用数组 `nums[n][n]` 来记录匹配的数量，`nums[i][j]`表示以 `s1[i]` 结尾的字符子串，和以 `s2[j]`结尾的字符子串，两者的匹配字符的最大数值。

- 当 `s1[i] == s2[j]`:
    -  如果 `i == 0` 或者 `j == 0`: `nums[i][j] = 1`
    -  否则 `nums[i][j] = nums[i - 1][j - 1] + 1;`
- 如果 `s1[i] ！= s2[j]`，则 `nums[i][j]=0`

前面说的其实就是状态转移表达式，也就是 `nums[i][j]` 是怎么求解的？`nums[i][j]` 是依赖于 `nums[i - 1][j - 1]` 和 当前字符是否匹配，如果当前字符不匹配，直接赋值为 0，只有在当前字符匹配的情况下，才会需要看前面一位的匹配数值 `nums[i - 1][j - 1]`。

假设以 `babad` 为例子：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210913001730.png)

最后两行的计算：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210913001823.png)

实现的代码如下：

```java
class Solution {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int len = s.length();
        String s1 = new StringBuffer(s).reverse().toString();
        int[][] nums = new int[len][len];
        int end = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (s1.charAt(i) == s.charAt(j)) {
                    if (i == 0 || j == 0) {
                        nums[i][j] = 1;
                    } else {
                        nums[i][j] = nums[i - 1][j - 1] + 1;
                    }
                }
                if (nums[i][j] > max) {
                    if (len - i - 1 + nums[i][j] - 1 == j) {
                        end = j;
                        max = nums[i][j];
                    }
                }
            }
        }
        return s.substring(end - max+1, end+1);
    }
}
```

### 马拉车算法
这是一个奇妙的算法，是1957年一个叫Manacher的人发明的，所以叫`Manacher‘s Algorithm`,主要是用来查找一个字符串的最长回文子串，这个算法最大的贡献是将时间复杂度提升到线性，前面我们说的动态规划的时间复杂度为 O(n<sup>2</sup>)。

前面说的中心拓展法，中心可能是字符也可能是字符的间隙，这样如果有 n 个字符，就有 `n+n+1` 个中心：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210920135756.png)

为了解决上面说的中心可能是间隙的问题，我们往每个字符间隙插入”`#`“,为了让拓展结束边界更加清晰，左边的边界插入”`^`“,右边的边界插入 "`$`":

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210920141619.png)

`S` 表示插入"`#`","`^`","`$`"等符号之后的字符串，我们用一个数组`P`表示`S`中每一个字符能够往两边拓展的长度:

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210920142055.png)

比如 `P[8] = 3`，表示可以往两边分别拓展3个字符,**也就是回文串的长度为 3**，去掉 `#` 之后的字符串为`aca`：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210920142403.png)

`P[11]= 4`，表示可以往两边分别拓展4个字符，**也就是回文串的长度为 4**，去掉 `#` 之后的字符串为`caac`：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210920142710.png)

**假设我们已经得知数组P，那么我们怎么得到回文串？**

用 `P` 的下标 `index` ，减去` P[i]`（也就是回文串的长度），可以得到回文串开头字符在拓展后的字符串 `S` 中的下标，除以2，就可以得到在原字符串中的下标了。

那么现在的问题是：**如何求解数组P[i]**

其实,马拉车算法的关键是：**它充分利用了回文串的对称性，用已有的结果来帮助计算后续的结果。**

假设已经计算出字符索引位置 P 的最大回文串，左边界是P<sub>L</sub>，右边界是P<sub>R</sub>：

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210921230726.png)

那么当我们求因为一个位置 `i` 的时候，`i` 小于等于 P<sub>R</sub>,其实我们可以找到 `i` 关于 `P` 的对称点 `j`:

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210921231133.png)

那么假设 j 为中心的最长回文串长度为 len，并且在 P<sub>L</sub> 到 P 的范围内，则 i 为中心的最长回文串也是如此：

**以 i 为中心的最长回文子串长度等于以 j 为中心的最长回文子串的长度**

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210921231550.png)

但是这里有两个问题：
- 前一个回文字符串P，是哪一个？
- 有哪些特殊情况？特殊情况怎么处理？

(1) 前一个回文字符串 `P`，是指的前面计算出来的**右边界最靠右的回文串**，因为这样它最可能覆盖我们现在要计算的 i 为中心的索引，可以尽量重用之前的结果的对称性。

也正因为如此，我们在计算的时候，需要不断保存更新 P 的中心和右边界，用于每一次计算。

(2) 特殊情况其实就是当前 i 的最长回文字符串计算不能再利用 P 点的对称，例如：

1. 以 `i` 的回文串的右边界超出了 `P` 的右边界 P<sub>R</sub>:

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210921233747.png)

这种情况的解决方案是：超过的部分，需要按照中心拓展法来一一拓展。

2. `i` 不在 以 `P` 为中心的回文串里面，只能按照中心拓展法来处理。

![](https://markdownpicture.oss-cn-qingdao.aliyuncs.com/blog/20210921234158.png)

具体的代码实现如下：

```java
    // 构造字符串
    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret = ret + "#" + s.charAt(i);
        ret = ret + "#$";
        return ret;
    }

    // 马拉车算法
    public String longestPalindrome(String str) {
        String S = preProcess(str);
        int n = S.length();
        // 保存回文串的长度
        int[] P = new int[n];
        // 保存边界最右的回文中心以及右边界
        int center = 0, right = 0;
        // 从第 1 个字符开始
        for (int i = 1; i < n - 1; i++) {
            // 找出i关于前面中心的对称
            int mirror = 2 * center - i;
            if (right > i) {
                // i 在右边界的范围内，看看i的对称点的回文串长度，以及i到右边界的长度，取两个较小的那个
                // 不能溢出之前的边界，否则就得中心拓展
                P[i] = Math.min(right - i, P[mirror]);
            } else {
                // 超过范围了，中心拓展
                P[i] = 0;
            }

            // 中心拓展
            while (S.charAt(i + 1 + P[i]) == S.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 看看新的索引是不是比之前保存的最右边界的回文串还要靠右
            if (i + P[i] > right) {
                // 更新中心
                center = i;
                // 更新右边界
                right = i + P[i];
            }

        }

        // 通过回文长度数组找出最长的回文串
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;
        return str.substring(start, start + maxLen);
    }
```

至于算法的复杂度，空间复杂度借助了大小为n的数组，为O(n)，而时间复杂度，看似是用了两层循环，实则不是 O(n<sup>2</sup>)，而是 `O(n)`，因为绝大多数索引位置会直接利用前面的结果以及对称性获得结果，常数次就可以得到结果，而那些需要中心拓展的，是因为超出前面结果覆盖的范围，才需要拓展，拓展所得的结果，有利于下一个索引位置的计算，因此拓展实际上较少。