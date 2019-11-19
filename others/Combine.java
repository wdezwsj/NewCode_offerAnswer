package com.company.others;

import java.util.ArrayList;

//求给定数组的排列组合
public class Combine {

    static ArrayList<Integer> list = new ArrayList<>();

    /**
     * 长度为k的所有组合
     * @param index arr的最小索引
     * @param k 组合的长度
     * @param arr 数组
     */
    public static void combine(int index, int k, int[] arr){
        if (k == 1){
            for (int i = index; i < arr.length; i++){
                list.add(arr[i]);
                System.out.println(list);
                list.remove(Integer.valueOf(arr[i]));
            }
        }else {
            for (int i = index; i <= arr.length-k; i++){
                list.add(arr[i]);
                combine(i+1,k-1,arr);
                list.remove(Integer.valueOf(arr[i]));
            }
        }
    }

    //两个数的所有组合
    public static void combineTwoNum(int[] arr){
        for (int i = 0; i <= arr.length-2; i++){
            list.add(arr[i]);
            for (int j = i+1; j < arr.length; j++){
                list.add(arr[j]);
                System.out.println(list);
                list.remove(Integer.valueOf(arr[j]));
            }
            list.remove(Integer.valueOf(arr[i]));
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args){
//        combine(0,3,new int[]{1,2,3,4,5,6,7,8,9,10});
//        combineTwoNum(new int[]{1,2,3,4,5,6,7,8,9,10});
        arrangement(0,4,new int[]{1,2,3,4,5,6,7,8});
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * 长度为k的所有排列
     * @param k 组合的长度
     * @param arr 数组
     */
    public static void arrangement(int index, int k, int[] arr){
        if (k == 1){
            for (int i = index; i < arr.length; i++){
                list.add(arr[i]);
                System.out.println(list);
                list.remove(Integer.valueOf(arr[i]));
            }
        }else {
            for (int i = index; i < arr.length; i++){
                swap(arr,index,i);
                list.add(arr[index]);
                arrangement(index+1,k-1,arr);
                list.remove(Integer.valueOf(arr[index]));
                swap(arr,index,i);

            }
        }
    }

    private static void swap(int[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

}
