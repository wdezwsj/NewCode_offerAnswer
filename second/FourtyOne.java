package com.company.second;

import java.util.ArrayList;

//和为S的连续正数序列
public class FourtyOne {

    //思路：
    //连续的和可以理解为活动窗口
    //首先设置左指针和右指针，和为两指针之间的数之和
    //若和小于S，就右移右指针；若和大于S，就右移左指针
    //若和等于S，就记录该序列，然后右移右指针
    //终止条件，右指针移动到(S+1)/2处，因为题目要求至少包含两个数
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 2){
            return result;
        }
        //窗口下标初始化
        int left = 1, right = 2, x = 3;
        //限制条件
        while (right <= ((sum+1)/2)){
            if (x < sum){
                //和小了，就右移右指针扩大窗口
                right++;
                x += right;
            }else if (x == sum){
                //满足条件，则构造结果添加进去
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++){
                    list.add(i);
                }
                result.add(list);
                right++;
                x += right;
            } else {
                //和大了，就右移左指针缩小窗口
                x -= left;
                left++;
            }
        }
        return result;
    }
}
