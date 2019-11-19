package com.company.second;

//整数中1出现的次数
public class ThirtyOne {

    //思路：
    //对于个位数上的1，每10个数出现一次，即0~9中有一个1；
    //对于十位数上的1，每100个数出现十次，即0~99中有10,11,12,13,14,15,16,17,18,19十个一；
    //对于百位数上的1，每1000个数出现100次，即100---199
    //以此类推
    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0){
            return 0;
        }
        //1出现的次数
        int sum = 0;
        //区间
        int gap = 10;
        while (n / gap != 0){
            //sum分为整除部分和余数部分
            //比如217，在看十位数上的1时，217/100=2，又因为每100个数中十位数上位1的数有10个，所以整数部分为2*10
            //217%100=17,17中十位数上位1的是有8个，即17-10+1=8
            sum += (n/gap)*(gap/10) + Math.min(Math.max((n%gap - gap/10 + 1),0),gap/10);
            gap *= 10;
        }
        //当n/gap为0时，表示n刚好处于gap/10~~gap这个区间中，所以还需要把余数部分的1 加进去
        sum += Math.min(Math.max((n%gap - gap/10 + 1),0),gap/10);
        return sum;
    }

    public static void main(String[] args){
        NumberOf1Between1AndN_Solution(21);
    }

}
