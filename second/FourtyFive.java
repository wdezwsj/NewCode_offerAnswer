package com.company.second;

import java.util.Arrays;

//扑克牌顺子
public class FourtyFive {

    //思路：
    //数组中的0代表赖子
    //直接排序，计算0的个数，再计算非零数之间的间隔值之和
    //比较0的个数和间隔值之和，若0的个数小于间隔值之和，则返回false，反之返回true
    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0){
            return false;
        }
        //排序
        Arrays.sort(numbers);
        int zeros = 0;
        int i = 0;
        //首先找0的个数
        for (; i < numbers.length; i++){
            if (numbers[i] == 0){
                zeros++;
            }else {
                break;
            }
        }
        //然后求间隔之和
        int gapSum = 0;
        while (i < numbers.length-1){
            int gap = numbers[i+1] - numbers[i];
            if (gap == 0){
                //若两张牌相同，必定不能成为顺子
                return false;
            }
            gapSum += gap-1;
            i++;
        }
        return zeros >= gapSum;

    }

}
