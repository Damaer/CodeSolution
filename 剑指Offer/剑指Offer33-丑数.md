# 33.丑数

## 题目描述
把只包含质因子`2`、`3`和`5`的数称作丑数（`Ugly Number`）。例如`6`、`8`都是丑数，但`14`不是，因为它包含质因子`7`。 习惯上我们把`1`当做是第一个丑数。求按从小到大的顺序的第`N`个丑数。

如果`n = 9`， 返回 `10`。注意事项：我们可以认为`1`也是一个丑数。

**输入**
> 7

**返回值**
> 8 


## 思路 & 解答

### 暴力破解
首先，我们想到的是暴力破解，从1开始遍历，每一个数，都不断地除以2,3,5，看最后的结果是不是等于1，如果等于1则说明这个数是丑数，否则不是丑数。

代码如下（这样的结果就是很大的数据就会时间超限，跑得很慢）：
``` java
public class Solution {
    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        for(int i=1;;i++){
            if(isUglyNumber(i)==true)
                n--;
            if(n==0)
                return i;
        }
    }
    public boolean isUglyNumber(int num){
        while(num%2==0)
            num/=2;
        while(num%3==0)
            num/=3;
        while(num%5==0)
            num/=5;
        if(num==1)
            return true;
        else 
            return false;
    }
}
```

### 换种思路
那么我们现在来看另一种解法，我们知道所有的丑数都是由 2 , 3 , 5 不断相乘产生的，也就是说，丑数只由丑数来产生，我不断地从前面的丑数中去产生新的丑数，直到第n个。首先定义了一个n个空间的一维数组，只把 `num[0]=1` ,然后我们使用下标移动法（我自己编的），也就是我们定义 3 个下标，分别是`num_2`,`num_3`,`num_5`,这些下标一开始都指向数组的0号元素，也就是他们的值都为0。

意思是下一个丑数由数组中 第 num_2 的元素*2 ， 和 第num_3的元素*3 ， 第num_5的元素乘以5 ，这三个数中最小的来产生，一旦确定是最小的，那么该下标就要往后面移动。

比如第二个数，第一次下标都在 0，我们找到`num[0]`，然后用2,3,5分别乘以`num[0]`，得到 2 , 3 ,5，发现2最小，那么`num[1]`就是2，这时候`num_2`这个下标就要移动到1，而`num_3`,`num_5`不变，还是0。

第三个数将由`num[1]*2`,`num[0]*3`,`num[0]*5`来产生，得到第三个数是3，那么`num_3`这个下标就要后移到1。

第四个数就由`num[1]*2`,`num[1]*3`,`num[0]*5`，发现`num[1]*2=4`最小，所以第四个数就是4，`num_2`这个下标又后移。

此时`num_2=2`，`num_3=1`，`num_5=0`...就这样不断地操作，得到最终的结果。

那么值得注意的是，如果三个数里面有两个是一样的，也就是可能`num[num_2]*2`刚好就等于`num[num_3]*3`,那么我们就要`num_2`，`num_3`两个都下标都移动，所以不能使用`if-else`，而是使用都使用`if`判断。代码如下：


```java
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int[] ugly = new int[index];
        ugly[0] = 1;
        int num_2 = 0, num_3 = 0, num_5 = 0, i = 1;
        for (i = 1; i < index; i++) {
            ugly[i] = getmin(ugly[num_2] * 2, ugly[num_3] * 3, ugly[num_5] * 5);
            if (ugly[i] / ugly[num_2] == 2)
                num_2++;
            if (ugly[i] / ugly[num_3] == 3)
                num_3++;
            if (ugly[i] / ugly[num_5] == 5)
                num_5++;
        }
        return ugly[index - 1];
    }
    public int getmin(int a, int b, int c) {
        return a < (b < c ? b : c) ? a : (b < c ? b : c);
    }
}
```







