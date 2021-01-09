@[toc]
# 题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0。

# 思路以及解法
首先题目中的double类型应该不能拆解，但是int类型的整数exponet我们可以做点文章，我们平时求次方的时候，假设有个x的4次方，我们通常是求出一个x的平方数x^2，然后两个x^2相乘就可以得出x^4。

这里思路也一样，使用递归，同时考虑边界条件。
如果指数是负数，则先取反，最后取结果的倒数即可。

$$Power(base,ex)=\begin{cases}
base*Power(base,ex-1),ex取余2=1 \\
Power(base,ex/2)*Power(base,ex/2),ex取余2=0\\
\end{cases}
$$
```java
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            // 指数为0则直接返回1
            return 1;
        }
        if (base == 0) {
            //底数为0直接返回0
            return 0;
        }
        // 判断指数是否为负数
        boolean isNegative = false;
        if (exponent < 1) {
            exponent = -exponent;
            isNegative = true;
        }
        double result;
        if (exponent % 2 == 1) {
            result = base * Power(base, exponent - 1);
        } else {
            double temp = Power(base, exponent / 2);
            result = temp * temp;
        }
        return isNegative ? (1.0 / result) : result;
    }
```


