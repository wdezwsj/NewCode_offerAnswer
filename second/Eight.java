package com.company.second;

//跳台阶
public class Eight {

    //思路：
    //青蛙每次可能跳一级台阶，也可能跳两级台阶
    //从后往前看，对于第n级台阶，青蛙可能是从n-1级台阶跳一步上来的，也可能是从n-2级台阶跳两级台阶上来的
    //那么对于第n-1级台阶，n-2级台阶也采取同样的思路，
    //一直减到第2级台阶，可能是由青蛙跳两次一级台阶上来的或者是一次跳两级台阶上来的，所以等于2
    //第1级台阶，只可能是青蛙跳一阶台阶上来的
    public int JumpFloor(int target) {
        if (target <= 2){
            return target;
        }
        return JumpFloor(target-1) + JumpFloor(target-2);
    }

}
