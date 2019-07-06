package com.company.second;

//数组中只出现一次的数字
public class Fourty {

    //思路：
    //两种方法，①HashMap，这里不多解释了；②异或运算
    //异或运算的原理，相同为0，不同为1
    //所以若一个数组中，除了一个数字外，其他数若都出现了偶数次，那么整个数组做完异或操作的结果就为那个单独的数
    //该题中是有两个数只出现了一次，其他数都出现了两次，所以整个数组异或得到的结果等同于是那两个数异或的结果
    //然后对最终的异或结果进行位移操作，从低位开始寻找位值为1的位置，表示这两个数在该位上一定是不同的（参考异或的原理）
    //然后以该位是否为1对原始数组进行分堆，分成的两堆中就会各含有一个只出现一次的数
    //最后分别对两个堆进行异或操作，就能得到最终答案
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length <= 1){
            return;
        }
        //首先对整个数组异或
        int temp = 0;
        for (int i = 0; i < array.length; i++){
            temp = temp^array[i];
        }
        //然后对temp进行移位操作，寻找值为1的低位
        int index = 0;
        while (index < 32 && (temp & 1) == 0){
            temp = temp >> 1;
            index++;
        }
        //再进行分堆并在堆内进行异或操作
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++){
            //分堆
            if (((array[i] >> index) & 1) == 1){
                //堆内异或操作
                num1[0] = num1[0] ^ array[i];
            }else {
                num2[0] = num2[0] ^ array[i];
            }
        }
    }

}
