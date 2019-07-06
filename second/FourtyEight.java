package com.company.second;

//不用加减乘除做加法
public class FourtyEight {

    //思路：
    //要求不能使用四则运算符，实现两个数相加的效果
    //既然四则运算都不让用，那么就使用位运算

    //利用异或的特性，相同为0，不同为1，即两数异或的结果得到的是不考虑进位的两数相加的结果
    //再通过与操作的特性，二者同为1才得1，其他为0，即两数相与可以得到两数相加的进位的表达
    //对该相与的结果左移一位，就能能得到进位的结果

    //最后，把不考虑进位的结果和只考虑进位的结果继续“相加”，即把二者当做新的num1和num2执行上述步骤
    //直到进位结果全是0，则代表num1已经是最终结果。
    public int Add(int num1,int num2) {
        if (num1 == 0){
            return num2;
        }
        if (num2 == 0){
            return num1;
        }
        while (num2 != 0){
            int a = num1 ^ num2;
            int b = (num1 & num2) << 1;
            num1 = a;//不考虑进位的结果
            num2 = b;//进位的结果
        }
        return num1;
    }

}
