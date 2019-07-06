package com.company.second;

//左旋转字符串
public class FourtyThree {

    //思路：
    //由于是循环左移，所以先通过求余得到实际左移位数
    //然后调用String内置函数，对字符串进行切割
    //再前后反转合并切割后的字符串
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0){
            return str;
        }
        int length = str.length();
        //实际移位数
        int x = n % length;
        return str.substring(x) + str.substring(0,x);
    }

}
