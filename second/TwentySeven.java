package com.company.second;

import java.util.ArrayList;
import java.util.Collections;

//字符串的排列
public class TwentySeven {

    ArrayList<String> list = new ArrayList<>();
    //思路：
    //排列就是递归加循环
    //每一次递归都是为了确定当前位的值
    //每一次递归里面的循环是为了尝试当前位置的所有值
    //递归完成之后必须要回退状态，详细的说明看代码注释
    public ArrayList<String> Permutation(String str) {

        if (str == null || str.length() == 0){
            return list;
        }
        Permutation(str.toCharArray(),0);
        //由于要按字典序打印，所以对最终结果排序
        Collections.sort(list);
        return list;
    }

    //确定index位置的字符
    private void Permutation(char[] array, int index) {
        if (index == array.length-1){
            //当index遍历到数组最后一个字符时，表示已生成一个字符串的排列
            String str = String.valueOf(array);
            if (!list.contains(str)){
                //防止重复
                list.add(str);
            }
        }else {
            //index位置的值要靠遍历来逐一确定
            for (int j = index; j <= array.length-1; j++){
                //交换
                swap(array,index,j);
                //继续确定下一位的字符
                Permutation(array,index+1);
                //重点，每一次排列结束后要回退到上一次的状态
                //所以仍旧交换
                swap(array,index,j);
            }
        }
    }

    //交换方法
    private void swap(char[] array, int index, int j) {
        char temp = array[index];
        array[index] = array[j];
        array[j] = temp;
    }

}
