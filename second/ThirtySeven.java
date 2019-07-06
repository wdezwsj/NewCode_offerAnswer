package com.company.second;

//数字在排序数组中出现的次数
public class ThirtySeven {

    //思路：
    //既然已经是排序数组了，那么要联想到二分查找！
    //二分查找在这题中可以有两种用法
    //①用二分查找来定位k的首位和末位，二者相减加一即为答案
    //②用二分查找来定位k-0.5和k+0.5的位置，二者相减即为答案

    //这里只展示方法二的答案
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0){
            return -1;
        }
        int start = 0, end = array.length-1;
        int a = find(array,k-0.5);
        int b = find(array,k+0.5);
        return b - a;
    }

    private int find(int[] array, double k) {
        int start = 0, end = array.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (array[mid] < k){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        //此处start代表大于k的数的首位置
        //即传入k-0.5，返回的是k的首位置；传入k+0.5，返回的是k+1的首位置
        return start;
    }

}
