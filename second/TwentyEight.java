package com.company.second;

//数组中出现次数超过一半的数字
public class TwentyEight {

    //思路：
    //由于某数出现的次数会超过数组的一半，所以我们可以用计数的方式，
    //先记录一个数，然后将该数与后面的数进行比较。
    //两数相同加一，不同减一，若减到0，则记录下一个数
    //遍历到最后所记录的数一定是最多的数之一（可能存在这种情况1，1，1，2，2，3，3，3。最后记录的3，但是3并没有超过数组长度的一半）
    //最后遍历一遍数组，判断该数的出现次数是否大于数组长度的一半
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int x = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++){
            if (count == 0){
                x = array[i];
                count++;
            }else {
                if (array[i] == x){
                    count++;
                }else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == x){
                count++;
                if (count > array.length/2){
                    return x;
                }
            }
        }
        return 0;
    }

}
