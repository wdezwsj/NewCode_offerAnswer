package com.company.second;

//连续子数组的最大和
public class Thirty {

    //思路：
    //前面的数所累计的和如果小于0，则对于下一个数来说，可以理解为是一种“拖累”，所以从下一个数开始重新计算累计的和。
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if (sum < 0){
                sum = array[i];
            }else {
                sum += array[i];
            }
            max = sum > max? sum: max;
        }
        return max;
    }

}
