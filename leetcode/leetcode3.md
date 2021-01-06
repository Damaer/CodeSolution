## 题目
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
**示例 1:**

>输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

**示例 2:**

>输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。


**示例 3:**

>输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

**示例 4:**

>输入: s = ""
输出: 0
 

**提示：**
>0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

## 思路以及解答
这是一道滑动窗口的经典题目，也就是有两个指针，`low`和`high`，同时借助一个`hashmap`,遍历到每一个字符的时候，都要判断`hashmap`里面是否已经包含。
- 如果不包含该字符，那么直接添加进去.
- 如果已经包含该字符，则根据`key`取出`value`，也就是它的上一次出现的索引位置。
    - 如果索引位置不在当前的区间[low,high]中，那也是直接`put`进去，`key`是当前字符，`value`是当前的索引。
    - 如果索引位置在当前的区间[low,high]中，则计算当前的不重复字符区间`high-low`，和之前保存的最大值`max`对比，满足则更新最大值。同时把`low`修改为上次出现的字符下一个索引位置。将当前的索引`high`字符以及索引添加到`map`中。

遍历字符串的每个字符，最后得到的`max`，就是最长字串。

``` java
class Solution {
public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int low = 0;
        int high = 0;
        int max  = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(;high<s.length();high++){
            String temp = s.charAt(high)+"";
            if(!map.containsKey(temp)){
                map.put(temp,high);
            }else {
                int index = map.get(temp);
                if(index<low){
                    map.put(temp,high);
                }else {
                    max = Math.max(max, (high - low));
                    low = index + 1;
                    map.put(temp, high);
                }
            }
        }
        max = Math.max(max,(high-low));
        return max;
    }
}
```