package com.company.second;

//翻转单词顺序列
public class FourtyFour {

    //思路：
    //“student. a am I”-------> “I am a student.”
    //单词内部拼写没问题，要调整的是单词出现的顺序
    //先判断是否是只含有" "的字符串，然后以" "为标识切割字符串，最后从后往前组合起来
    //注意最后一个单词不用加" "
    public static String ReverseSentence(String str) {
        if ("".equals(str.trim())){
            return str;
        }
        String[] array = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = array.length -1; i >= 0; i--){
            stringBuilder.append(array[i]);
            if (i != 0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

}
