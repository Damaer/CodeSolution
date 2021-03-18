## 题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"`go`"时，第一个只出现一次的字符是"`g`"。当从该字符流中读出前六个字符“`google`"时，第一个只出现一次的字符是"`l`"。

**返回值描述:**
如果当前字符流没有存在出现一次的字符，返回`#`字符。

## 思路以及解答
这道题有两个函数要求实现，主要是输入函数和输出函数，一个是读入新的字符，另外一个是输出第一个只出现一次的字符。

我的做法是借助一个数组和一个队列，数组中是存储了元素出现的次数，会不断的往上面叠加，字母一般128个就足够了。
队列的话，主要是存储元素出现的顺序。

**添加元素的函数：**

判断计数数组里面，字符出现的个数是不是为0，为0则往队列里面添加元素，如果不为0，添加了没有意义，说明包括当前出现的至少出现了两次。同时更新计数器。

**查找第一个只出现一次的字符**
判断队列里面是否为空，取出第一个元素，不为空的时候，判断计数器里面该字符出现的次数是不是为1，为1的时候直接返回该字符，如果不是1，那么直接把该字符从队列里面移除，说明出现不止一次了。
直到队列为空，返回“#”。

```java

import java.util.Queue;
import java.util.LinkedList;
import java.lang.Character;

public class Solution {
    int[] charCount = new int[128];
    Queue<Character> queue = new LinkedList<Character>();

    // 模拟输入字符
    public void Insert(char ch) {
        if (charCount[ch] == 0) {
            queue.add(ch);
        }
        charCount[ch]++;
    }

    // 模拟输出第一个只出现一次的字符
    public char FirstAppearingOnce() {
        Character character = null;
        char c = 0;
        // 取出队列的第一个
        while ((character = queue.peek()) != null) {
            // 取出里面的字符
            c = character.charValue();
            // 判断个数是不是为1
            if (charCount[c] == 1) {
                return c;
            }
            else {queue.remove();}
        }
        return '#';
    }
}
```

时间复杂度为`O(n)`，空间复杂度也为`O(n)`。