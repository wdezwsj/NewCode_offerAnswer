package com.company.second;

//圆圈中最后剩下的数
public class FourtySix {

    //思路：
    //两种方法，①环形链表，用ArrayList实现；②约瑟夫环
    //此处用约瑟夫环来实现
    //当前轮，有n人，第（m-1）% n人退出,第m % n人作为下一轮的第0人继续
    //可以理解为下一轮中的第0人，在上一轮中的位置是(m+0) % n;
    //以此类推，下一轮中的第K人，在上一轮中的位置是(m+K) % n;
    //以上述规律，可以通过迭代，也可以通过递归来寻找 有n人时的喊m-1的人的索引。
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1) {
            return -1;
        }
        if (n == 1){
            //只有一个人时，喊m-1的人是零号位的人
            return 0;
        }
        return (m + LastRemaining_Solution(n-1,m)) % n;
    }

    //迭代写法
    public int LastRemaining_Solution2(int n, int m) {
        if(n < 1 || m < 1) {
            return -1;
        }
        if (n == 1){
            //只有一个人时，喊m-1的人是零号位的人
            return 0;
        }
        int x = 2;
        int index = 0;
        while (x <= n){
            index = (m + index) % x;
            x++;
        }
        return index;
    }

}
