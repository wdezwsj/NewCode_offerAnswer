package com.company.others;

//01背包问题
public class BackPack {

    private int[][] temp;

    //递归解法，自顶向下
    public int knapSack(int[] w, int[] v, int C) {
        temp = new int[w.length][C+1];
        return solveKS(w,v,w.length-1,C);
    }

    private int solveKS(int[] w, int[] v, int index, int capacity) {
        if (index < 0 || capacity <= 0){
            return 0;
        }
        if (temp[index][capacity] != 0){
            return temp[index][capacity];
        }
        //如果不放入index元素
        int result = solveKS(w,v,index-1,capacity);
        //如果放入index元素
        if (capacity >= w[index]){
            //比较放入和不放入哪种更大
            result = Math.max(result, solveKS(w,v,index-1,capacity-w[index]) + v[index]);
        }
        temp[index][capacity] = result;
        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    //迭代解法，自底向上
    static int[] memo;
    public static int knapSack2(int[] w, int[] v, int C) {
        if (C == 0 || w.length == 0){
            return 0;
        }
        memo = new int[C+1];
        for (int i = 0; i < w.length; i++){
            for (int j = memo.length - 1; j >= w[i]; j--){
                memo[j] = Math.max(memo[j], memo[j-w[i]]+v[i]);
            }
        }
        return memo[C];
    }

    public static void main(String[] args) {
        int[] w = {200, 600, 100, 180, 300 ,450};
        int[] v = {6, 10, 3, 4, 5, 8};
        System.out.println(knapSack2(w, v, 1000));
    }

}
