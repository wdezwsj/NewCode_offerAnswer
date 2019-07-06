package com.company.second;

//机器人的运动范围
public class SixtySix {

    //思路：
    //和上一题思路相似，也是选择上下左右的递归过程，也需要排除掉复用的点
    //因为题目要求的是求能到达的点的总和，所有把四种可能的返回值相加即为答案。

    boolean[] flags;
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0){
            return 0;
        }
        flags = new boolean[rows * cols];
        return moving(threshold,rows,cols,0,0);
    }

    private int moving(int threshold, int rows, int cols, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols){
            return 0;
        }
        if (flags[row * cols + col]){
            return 0;
        }
        int rowSum = 0;
        int colSum = 0;

        int temp = row;
        while (temp > 0){
            rowSum += temp % 10;
            temp /= 10;
        }
        temp = col;
        while (temp > 0){
            colSum += temp % 10;
            temp /= 10;
        }
        if (rowSum + colSum <= threshold){
            flags[row * cols + col] = true;
            //别忘了加1，代表自身这个点
            return moving(threshold,rows,cols,row+1,col)
                    + moving(threshold,rows,cols,row-1,col)
                    + moving(threshold,rows,cols,row,col+1)
                    + moving(threshold,rows,cols,row,col-1)
                    + 1;
        }
        return 0;
    }

}
