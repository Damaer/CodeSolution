# 53.表达数值的字符串

## 题目描述
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"`+100`","`5e2`","`-123`","`3.1416`"和"`-1E-16`"都表示数值。 但是"`12e`","`1a3.14`","`1.2.3`","`+-5`"和"`12e+4.3`"都不是。

**示例1**

**输入**
> "123.45e+6"

**返回值**
> true

## 思路 & 解答
这道题咋一看，有点复杂，`case`很多，主要是分析好判断分支，我们可以定义几个变量：
- `hashNum`: 是否已经有数字
- `hashE`：是否已经有E
- `hasSign`：是否已经有符号
- `hasDot`：是否已经有小数点

首先，初始化当前的索引`index =0`，字符串头部的空格需要跳过。

- 循环判断索引是否在有效的范围内：
  - 循环判断是否是数字，是数字则更新`hasNum = true`,并且索引后移，直到不是数字的时候，跳出循环。
- 跳出循环后，需要判断当前的`index`是否合法，不合法直接break
- 取出当前索引的字符`c`：
  - 如果`c`是`e`或者`E`：
    - 如果前面已经出现过`E`，或者前面没有数字，直接返回`false`
    - 否则，`hasE`置为`true`，其他的置为`false`，也就是E后面可以继续出现符号数字和小数点了
  - 如果`c`是“`+`”或者“`-`”：
    - 前面如果已经出现过数字或者符号或者小数点，都不是合法的
    - 否则`hasSign`置为`true`，表示符号出现过
  - 如果`c`是小数点“`.`”
    - 如果前面已经有小数点或者有E出现了，那么就是非法的，返回`false`
    - 否则`hasDot`置为`true`
  - 如果`c`为空格，直接跳出循环
  - 否则，直接返回`false`
- 最后也需要跳过空格
- 最后判断是否合法的条件是：是否到达最后一个字符，并且出现过数字


```java
    public boolean isNumeric(String str) {
        int size = str.length();
        int index= 0 ;
        // 默认全部是false
        boolean hashNum=false ,hasE=false ,hasSign=false ,hasDot=false;
        // 跳过空格
        while(index<size&&str.charAt(index)==' '){
            index++;
        }
        while(index<size){
            while(index<size&&str.charAt(index)>='0'&& str.charAt(index)<='9'){
                index++;
                // 表示前面有数字
                hashNum = true;
            }
            // 到末尾直接跳出
            if(index==size){
                break;
            }
            char c = str.charAt(index);
            if(c=='e'||c=='E'){
                // 前面有E或者没有数字在前面
                if(hasE||!hashNum){
                    return false;
                }
                hasE = true;
                // 出现E了后面又可以出现数字了
                hashNum = false;
                hasSign = false;
                hasDot = false;
            }else if(c=='+'||c=='-'){
                if(hasSign||hashNum||hasDot){
                    return false;
                }
                hasSign = true;
            }else if(c=='.'){
                if(hasDot||hasE){
                    return false;
                }
                hasDot =true;
            }else if(c==' '){
                break;
            }else{
                return false;
            }
            index++;
        }        
        // 跳过空格
        while(index<size&&str.charAt(index)==' '){
            index++;
        }
        return hashNum &&index==size;
    }
```

**总结一下**

这道题，其实本质是转态的切换，最最重要的一点，是`E`出现之后，其实小数点和符号，和数字，都是可以再出现的，可以理解为`E`就是一个分割线。