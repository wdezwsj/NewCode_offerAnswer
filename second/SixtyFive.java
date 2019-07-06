package com.company.second;

//矩阵中的路径
public class SixtyFive {

    //思路：
    //首先遍历整个矩阵来找起始点
    //然后每走下一步都是四种可能，即上下左右，进入下一步后又是同样的选择，所以是个明显的递归问题
    //关键点在于两点，一个是做好边界条件限制，
    //第二个是要通过一个同样大小的辅助数组来标识某个点是否已被访问过，且在回退时将该点的访问记录清除。

    boolean[] flags;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        flags = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++){
            int row = i / cols;
            int col = i % cols;
            if (pattern(matrix,rows,cols,str,0,row,col)){
                //匹配成功，直接返回true
                return true;
            }
        }
        return false;
    }

    private boolean pattern(char[] matrix, int rows, int cols, char[] str, int index, int row, int col) {
        if (index == str.length){
            //字符串匹配完
            return true;
        }
        if (row >= rows || row < 0 || col >= cols || col < 0){
            //索引超出矩阵边界
            return false;
        }
        if (flags[row * cols + col]){
            //重复进入某个点，返回false
            return false;
        }
        if (str[index] == matrix[row * cols + col]){
            flags[row * cols + col] = true;
            boolean result = pattern(matrix,rows,cols,str,index+1,row,col+1)
                    || pattern(matrix,rows,cols,str,index+1,row,col-1)
                    || pattern(matrix,rows,cols,str,index+1,row+1,col)
                    || pattern(matrix,rows,cols,str,index+1,row-1,col);
            if (result){
                return true;
            }
        }
        flags[row * cols + col] = false;
        return false;
    }

}
