package com.company.second;

import java.util.Arrays;
import java.util.Comparator;

//把数组排成最小的数
public class ThirtyTwo {

    //思路：
    //排成最小的数无非就是对数组按“某种规则”进行升序排列
    //一般的排序规则为自然大小
    //这里定义规则如下
    //首先将整形数转换成字符串，[A,B]
    //若AB > BA，那么B要小于A；反之，B要大于A
    //对所有字符串数组按如下规则进行排序，将最后的字符串数组转换为数即可。
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        //转换成字符串数组
        String[] array = new String[numbers.length];
        for (int i = 0; i <numbers.length; i++){
            array[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(array, new Comparator<String>() {
            @Override
            //自定义排序规则
            public int compare(String o1, String o2) {
                String a = o1+o2;
                String b = o2+o1;
                return a.compareTo(b);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (String str : array){
            builder.append(str);
        }
        return builder.toString();
    }

}
