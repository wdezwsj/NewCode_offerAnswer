package com.company.second;

//二维数组中的查找
public class One {

    //思路：
    //二维数组满足，每一行，从左到右递增；每一列，从上到下递增
    //要判断一个数在该二维数组中是否存在，我们可以以数组的右上角为起点
    //如果target比数组当前值要大，那么我们就向下移；如果target比数组当前值要小，那我们就向左移
    //直到移动到二位数组的边界还没匹配上的话，就说明不存在。
    //具体的实现方式可以用递归也可以用迭代，能用迭代尽量用迭代
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0){
            return false;
        }
        //定义行、列
        int row = 0, col = array[0].length-1;
        //边界条件
        while (row < array.length && col >= 0){
            if (array[row][col] == target){
                return true;
            }else if (array[row][col] < target){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }

}
