# 12. 数值的整数次方
## 题目描述
给定一个`double`类型的浮点数`base`和`int`类型的整数`exponent`。求base的`exponent`次方。保证`base`和`exponent`不同时为`0`。

## 思路 & 解答
首先题目中的`double`类型应该不能拆解，但是`int`类型的整数`exponet`我们可以做点文章，我们平时求次方的时候，假设有个`x`的4次方，我们通常是求出一个x的平方数`x^2`，然后两个`x^2`相乘就可以得出`x^4`。

这里思路也一样，使用递归，同时考虑边界条件。
如果指数是负数，则先取反，最后取结果的倒数即可。

$$
Power(base,ex)=\begin{cases}
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


