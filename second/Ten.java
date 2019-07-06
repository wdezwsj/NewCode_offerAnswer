package com.company.second;

//矩形覆盖
public class Ten {

    //思路：
    //矩形覆盖的思路和青蛙跳台阶类似，都可以从后往前推
    //对于有2*n的大矩形，其可能是由2*（n-1）的矩形加上一块2*1的矩形组成的，也可能是由2*（n-2）的矩形加上两块1*2的矩形组成的
    public int RectCover(int target) {
        if (target <= 2){
            return target;
        }
        return RectCover(target-1) +RectCover(target-2);

    }

}
