# 2.替换空格
## 题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

## 思路以及解答

### 调用API函数
`java`里面有可以直接使用的函数`replace()`，直接写成下面这样即可通过，但是这样真的没有意思啊。🤣🤣🤣
```java
public String replaceSpace(StringBuffer str) {
    String result = str.toString().replace(" ","%20");
    return result;
}
```
### 自实现
于是乎，决定自己实现，不直接调用 api.思路如下：
- 1.将字符串转换成为字符数组，遍历一次，统计出空格的个数。
- 2.构建出新的字符数组，**初始化的大小=原来的字符数组长度+空格长度x2**
- 3.遍历一次，复制，当不为空格时直接复制，当为空格时，则把`%20`这三个字符复制过去。

代码如下：

```java
public class Solution {
    public String replaceSpace(StringBuffer str) {
        // 转换成为字符数组
        char[] originChars= str.toString().toCharArray();
        int spaceNum = 0;
        // 计算出空格的个数
        for (int i = 0; i < originChars.length; i++) {
            if (originChars[i] == ' ') {
                spaceNum++;
            }
        }
        // 新字符数组的长度
        int newCharsLength = originChars.length + 2 * spaceNum;
        char[] newChars = new char[newCharsLength];
        int newStrIndex = 0;
        for (int index= 0; index<=originChars.length - 1; index++) {
            if(originChars[index] != ' '){
                // 直接复制
                newChars[newStrIndex++] = originChars[index];
            }else {
                // 空格则需要复制三个字符
                newChars[newStrIndex++] = '%';
                newChars[newStrIndex++] = '2';
                newChars[newStrIndex++] = '0';
            }
        }
        // 转成字符串
        return new String(newChars);
    }
}
```
### c++实现
c++实现差不多，主要是复制的时候从后面往前面开始复制，这样就可以节省一定空间，直接在原来的数组上操作。不需要重新创建一个空间。
```java
class Solution {
public:
    	void replaceSpace(char *str,int length) {
		if(str == NULL || length <= 0){
            return;
        }
        int originalLength = 0;
        int spaceNum = 0;
        int i;
        while(str[i++] != '\0'){
            ++originalLength;
            if(str[i] == ' '){
                ++spaceNum;
            }
        }

        int newCharsLength = originalLength + 2 * spaceNum;
        
        int indexOriginal = originalLength-1;
        int index = newCharsLength-1;
        
        while(indexOriginal >= 0 && index > indexOriginal){
            if(str[indexOriginal] == ' '){
                str[index--] = '0';
                str[index--] = '2';
                str[index--] = '%';
            }
            else{
                str[index--] = str[indexOriginal];
            }
            --indexOriginal;
        }
    }
};
```
