package com.company.second;

import java.util.ArrayList;

//顺时针打印矩阵
public class Nineteen {

    //思路：顺时针打印这个行为可以被分解成打印数组最外围的重复行为
    //而数组最外围需要有两个限制条件，即起始点（x,y）和最大值点（Xmax,Ymax）
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return list;
        }
        //横坐标最大值
        int xMax = matrix[0].length -1;
        //纵坐标最大值
        int yMax = matrix.length - 1;
        circle(list,matrix,0,0,xMax,yMax);
        return list;
    }

    private static void circle(ArrayList<Integer> list, int[][] matrix, int x, int y, int xMax, int yMax) {
        if (xMax < x || yMax < y){
            //只要有一个坐标越界了就表示已经循环完了
            return;
        }
        //左到右
        for (int i = x; i <= xMax; i++){
            list.add(matrix[y][i]);
        }
        //上到下
        for (int j = y+1; j <= yMax; j++){
            list.add(matrix[j][xMax]);
        }
        //关键判断！！！！！！
        if (x == xMax || y == yMax){
            //如果是单行或者单列，通常出现在最后一圈，则上面两步就已经遍历结束了
            return;
        }
        //右到左
        for (int k = xMax - 1; k >= x; k--){
            list.add(matrix[yMax][k]);
        }
        //下到上
        for (int h = yMax - 1; h >= y+1; h--){
            list.add(matrix[h][x]);
        }
        //这个位置可以不用递归来写
        circle(list,matrix,x+1,y+1,xMax-1,yMax-1);


    }

    public static void main(String[] args){
        printMatrix(new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}});
    }

}
