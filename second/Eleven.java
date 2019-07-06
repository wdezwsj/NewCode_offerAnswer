package com.company.second;

//二进制中1的个数
public class Eleven {

    //思路：
    //很简单，直接每右移一位就和1相与判断是不是1
    //因为int是4个字节32位，所以最多移32位
    public static int NumberOf1(int n) {
        int count = 0;
        //int是32位，直接全部遍历一遍即可
        for (int i = 0; i < 32; i++){
            if ((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(5 & 1);//1010
    }

}
