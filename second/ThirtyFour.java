package com.company.second;

import java.util.LinkedHashMap;
import java.util.Set;

//第一个只出现一次的字符
//返回该字符的位置
public class ThirtyFour {

    //思路：
    //通过一次遍历，将字符串中所有字符出现的次数保存在LinkedHashMap中，然后查找LinkedHashMap中第一个value为1的key在字符串中的位置。
    public int FirstNotRepeatingChar(String str) {
        if (str == null || "".equals(str)){
            return -1;
        }
        LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<>();
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++){
            if (hashMap.containsKey(array[i])){
                hashMap.put(array[i],hashMap.get(array[i])+1);
            }else {
                hashMap.put(array[i],1);
            }
        }
        Set<Character> set = hashMap.keySet();
        for (char ch : set){
            if (hashMap.get(ch) == 1){
                return str.indexOf(ch);
            }
        }
        //另一种搜寻法
//        for (int i = 0; i < array.length; i++){
//            if (hashMap.get(array[i]) == 1){
//                return i;
//            }
//        }
        return -1;
    }

}
