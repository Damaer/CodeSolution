# 44.翻转单词序列

## 题目描述
给定一个句子，将句子中的单词进行翻转，注意，单词内部的字符顺序不改变，改变的是单词与单词之间的顺序，比如“`I am a coder.`”,翻转之后变成“`coder. a am I`”。

**示例**
注意：引号内部才是输入的内容

**输入**
> "You are a cool boy."

**输出**
> "boy. cool a are You"

## 思路 & 解答

第一种方法，`Java`里面有切割字符串的方法，直接用空格进行分隔，分隔成为多个单词，然后从字符串数组的后面开始，每一个字符拼接上一个空格，但是，值得注意的一点是，当只剩下一个字符串的时候，也就是索引为`0`的时候，不需要再拼接空格。代码实现如下：
```java
public class Solution {
    public String ReverseSentence(String str) {
        if(str!=null&&str.length()!=0&&!str.equals("   ")){
            String[] strs = str.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=strs.length-1;i>=0;i--){
                stringBuilder.append(strs[i]);
                stringBuilder.append(i==0?"":" ");
            }
            return stringBuilder.toString();
        }
        return str;
    }
}
```

第二种方式，是借助堆栈，堆栈是先进后出，也就是我们切割完字符串之后，全部放到堆栈中，再全部取出来拼接，就可以完成逆序的操作。有一个值得注意的点，就是空格的问题，我们压栈的时候，跟随着拼接上空格即可，最后一个字符不压入空格。

```java
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return str;
        StringBuilder stringBuilder = new StringBuilder();
        String[] strs = str.split(" ");
        if (strs.length == 0)
            return str;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length - 1; i++) {
            stack.push(strs[i]);
            stack.push(" ");
        }
        stack.push(strs[strs.length - 1]);
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
```

前面已经讲过使用`JDK`的`api`切割字符串，以及使用堆栈实现倒序的方法，这里介绍的，是一个原生的方法。

首先判断字符串`str`是否为空或者为空字符，如果`str`不为空，则初始化`start`，和`end`指针指向字符串的尾部，`start`从尾部向头部遍历
- 针对每一个字符，如果字符为空字符：
    - 如果`start`和`end`不是出于同一个位置，说明已经遍历完一个单词，那么将`start+1`~`end`之间的字符，拼接到结果后，并且添加上一个空格。将`start-1`，并且`end`指向`start`的位置
    - 否则，说明是多余的空格，直接跳过，`start-1`，`end=start`
- 如果字符不是空字符：可以把`start`索引前移，也就是`start--`

最后，剩下最后一个单词的时候，需要特殊处理最后一个单词，拼接到字符串后面就可以了。


```java
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ReverseSentence("nowcoder. a am I"));
    }

    public String ReverseSentence(String str) {
        if (str != null && str.length() != 0 && !str.equals("   ")) {
            int start = str.length() - 1, end = start;
            StringBuffer stringBuffer = new StringBuffer();
            for (; start > 0; ) {
                // 如果为空格
                if (str.charAt(start) == ' ') {
                    // 且开始索引和结束索引不一致的情况
                    if (start != end) {
                        // 遍历start+1~end的字符，加到
                        for (int i = start + 1; i <= end; i++) {
                            stringBuffer.append(str.charAt(i));
                        }
                        // 每一个单词的后面加上一个空格
                        stringBuffer.append(" ");
                    }
                    start--;
                    end = start;
                } else {
                    start--;
                }
            }
            // 处理最后一个单词
            for (int i = 0; i <= end; i++) {
                stringBuffer.append(str.charAt(i));
            }
            return stringBuffer.toString();
        }
        return str;
    }
}
```

上面的做法，在遍历寻找单词的时候，相当于遍历完了一次字符串，将字符串拼接到结果字符串的时候，也相当于遍历完了一次字符串，假设字符串的长度为`n`，则需要`2n`次处理，也就是时间复杂度为`O(n)`。