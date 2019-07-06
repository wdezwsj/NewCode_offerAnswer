package com.company.second;

//构建乘积数组
public class FiftyOne {

    //思路：
    //B[i]是由除A[i]外A中所有元素的乘积构成的
    //我们可以把B[i]的组成看成两部分，左边的乘积和右边的乘积
    //左边和右边的乘积在各自内部都是连续的，所以我们可以用两个for循环来解决这个问题
    //第一遍循环解决左边乘积，第二遍循环解决右边的乘积
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length == 0){
            return B;
        }
        B[0] = 1;
        //左边乘积
        for (int i = 1; i < A.length; i++){
            B[i] = B[i-1] * A[i-1];
        }
        //右边乘积
        int temp = 1;
        for (int j = A.length-2; j >= 0; j--){
            temp = temp * A[j+1];
            B[j] = B[j] * temp;
        }
        return B;
    }

}
