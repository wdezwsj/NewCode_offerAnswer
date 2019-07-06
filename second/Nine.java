package com.company.second;

//变态跳台阶
public class Nine {

    //思路：
    //变态跳台阶还是按照上一题的思路来做，
    //对于第n级台阶，可能是由0,1,2,3，...... ,n-1级台阶跳上来的
    public int JumpFloorII(int target) {
        if (target <= 2){
            return target;
        }
        int sum = 1;
        for (int i = 1; i < target; i++){
            sum += JumpFloorII(i);
        }
        return sum;
    }

}
