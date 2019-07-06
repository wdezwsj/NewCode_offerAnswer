package com.company.second;

//丑数
public class ThirtyThree {

    //思路：
    //设置一个从小到大放置丑数的数组，第一个丑数为1
    //分别给2倍，3倍，5倍设置指针，指向被乘数
    //每一次寻找下一个丑数的过程就是比较三种倍数与被乘数的乘积中较小的那一个
    //然后将对应的倍数指针右移，往数组中加入丑数
    //重复上述步骤
    //注意：可能会出现某个丑数是两种倍数的结合，故对应的倍数指针都要右移
    public int GetUglyNumber_Solution(int index) {
        if (index < 1){
            return 0;
        }
        int index2 = 0, index3 = 0, index5 = 0;
        int[] array = new int[index];
        array[0] = 1;
        for (int i = 1; i < index; i++){
            int temp2 = array[index2]*2;
            int temp3 = array[index3]*3;
            int temp5 = array[index5]*5;
            //虽然三者都是丑数，但是此处取最小值，作为下一个丑数
            int min = Math.min(temp5,Math.min(temp2,temp3));
            if (min == temp2){
                index2++;
            }
            if (min == temp3){
                index3++;
            }
            if (min == temp5){
                index5++;
            }
            array[i] = min;
        }
        return array[index-1];
    }

}
