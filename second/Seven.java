package com.company.second;

//菲波那切数列
public class Seven {

    //思路：
    //求斐波那契数列切忌用递归，因为递归会造成大量重复计算，除非对中间计算结果做缓存
    //直接用迭代来求，循环n次就行
    public int Fibonacci(int n) {
        if (n <= 0){
            return 0;
        }
        int last = 0;
        int result = 1;
        for (int i = 1; i < n; i++){
            int temp = result + last;
            last = result;
            result = temp;
        }
        return result;
    }

}
