package com.company.second;

//求1+2+3+...+n
public class FourtySeven {

    //思路：
    //要求不能用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
    //能选的运算符号只有加法，但是不让用循环，那么我们就选择用递归来代替循环
    //递归需要结束条件，由于不让用条件判断语句，所以用短路与来做条件判断
    public static int Sum_Solution(int n) {
        int sum = n;
        //此处短路与运算只是为了做终止的条件判断
        boolean flag = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }

    public static void main(String[] args){
        System.out.print(Sum_Solution(10));
    }

}
