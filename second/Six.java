package com.company.second;

//旋转数组的最小数字
public class Six {

    //思路：
    //遍历比较下一个数是不是比啊array[0]小就行了
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int temp = array[0];
        for (int i = 1; i < array.length; i++){
            if (temp > array[i]){
                return array[i];
            }
        }
        return temp;
    }

}
