## 题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）

**示例1**

输入
> "google"

返回值
> 4

## 思路以及解答
1.第一种做法：使用`LinkedhashMap`，`key`是字符，`value`是索引，如果里面存在该字符，则将其索引置为一个极大值（999999999），如果不存在该字符，则将该字符以及索引存放到`map`中。最终查找出第一个`value`值不为（999999999）的`entry`，返回其`value`，也就是索引，如果不存在则返回-1。

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0){
            return -1;
        }
        Map<Character,Integer> hashMap = new LinkedHashMap<>();
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(hashMap.containsKey(c)){
                hashMap.put(c, 999999999);
            }else{
                hashMap.put(c,i);
            }
        }
        Map.Entry<Character,Integer> entry = hashMap.entrySet().stream().filter(e->e.getValue()!=999999999).findFirst().orElse(null);
        if(entry==null){
            return -1;
        }else{
            return entry.getValue();
        }
    }
}
```

2.第二种做法是，使用字符数组来统计，由于全都是字符，’A‘-’z‘一共58个字符（中间有其他字符）,比如’A‘对应下标0的元素，’B‘对应’2‘的元素。

数据里面的值，为元素出现的索引。初始化所有的值为-1，遍历字符串的字符，如果前面该字符已经存在，将其置设置为极大值（999999999)，否则设置为第一次出现的索引。

最终遍历数组，找出不为-1且不为999999999的元素，就是第一个只出现一次的字符的索引。

```java
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] nums = new int[58];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'A';
            if (nums[index] >= 0) {
                nums[index] = 999999999;
            } else {
                nums[index] = i;
            }
        }
        int index = 999999999;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1 && nums[i] != 999999999) {
                index = Math.min(index,nums[i]);
            }
        }
        return index==999999999?-1:index;
    }
```
