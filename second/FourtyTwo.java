package com.company.second;

import java.util.ArrayList;

//和为S的两个数字
public class FourtyTwo {

    //思路：
    //左右加逼法，两个指针分别起始于数组头和数组尾
    //若a[i] + a[j] == sum ，即为答案，因为靠近边缘的两数的乘积肯定小于中间两数的乘积
    //若a[i] + a[j] < sum ，则右移左指针，加大和的值
    //若a[i] + a[j] > sum ， 则左移右指针，减小和的值
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length <= 1){
            return result;
        }
        int i = 0, j = array.length-1;
        while (j > i){
            if (array[i] + array[j] == sum){
                result.add(array[i]);
                result.add(array[j]);
                return result;
            }else if (array[i] + array[j] < sum){
                i++;
            }else {
                j--;
            }
        }
        return result;

    }

}
