## 题目描述
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).

## 示例1
输入
[1,-2,3,10,-4,7,2,-5]

返回值
18

输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。 


第一种方法：暴力破解，使用两层循环，求每一个区间的和：

``` java
    public int simpleSolution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int tempSum = 0;
            for (int j = i; j < array.length; j++) {
                tempSum = tempSum + array[j];
                if (tempSum > result) {
                    result = tempSum;
                }
            }
        }
        return result;
    }
```

使用动态规划求解，动态规划只要找出状态转移方程，就意味着成功了一大半。首先我们定义这个问题：
`dp[i]`表示下标以i结尾的连续子数组的最大和，假设数组大小为`n`,那么最终求解的就是`dp[n-1]`。

下标以`i`结尾的连续子数组的最大和，怎么求呢？要想求dp[i],那我们现在假设一下，假设下标以`i-1`结尾的连续子数组的最大和为`dp[i-1]`,数组第`i`个元素是`nums[i]`，那么当前的连续子数组的最大和，要么是前面的加上当前的元素：`dp[i-1]+nums[i]`，要么是舍弃掉之前的`dp[i-1]（这个很可能是负数）`，取现在的nums[i];

因此，状态转移方程为：

dp[i]= Max{dp[i-1]+nums[i],nums[i]}


但是，值得注意的是，`Max{dp[i-1]+nums[i],nums[i]}`求得的仅仅是以`i`下标结尾的子数组的最大和，之前计算的连续子数组最大和需要保存起来，不断的和当前计算的最大和比较，取最大值。
``` java
    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max = array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }
```

