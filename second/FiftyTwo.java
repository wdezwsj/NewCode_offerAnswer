package com.company.second;

import com.sun.org.apache.regexp.internal.RE;

//正则表达式匹配
public class FiftyTwo {

    //思路：
    //字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）
    //由于过程较为复杂，详情见代码注释
    //核心思想就是考虑pattern的下一位是不是'*'
    public static boolean match(char[] str, char[] pattern) {
        return match(str,pattern,0,0);
    }

    public static boolean match(char[] str, char[] pattern, int i, int j){
        //二者同时到达尾部，这返回true；
        if (((i == str.length) && (j == pattern.length))){
            return true;
        }
        //若pattern先遍历到尾部，则这次匹配必定失败
        if (((i < str.length) && (j == pattern.length))){
            return false;
        }

        //若pattern存在下一位并且下一位为'*'
        if (((j + 1) < pattern.length) && pattern[j+1] == '*'){
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])){
                //这里要同时考虑两种情况
                //一种是选择继续用'*'做匹配，
                //另一种是主动选择跳过'*'匹配，尝试下一位做匹配
                return match(str,pattern,i+1,j) || match(str,pattern,i,j+2);
            }else {
                //若str已遍历到尾部，或者当前字符匹配失败，则pattern前进两步
                //如aaa 和 aaab*c*d*e* 这种情况
                return match(str,pattern,i,j+2);
            }
        }
        //pattern下一位不为'*'，直接匹配当前值
        if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])){
            //当前字符匹配成功，str和pattern共同前进一位
            return match(str,pattern,i+1,j+1);
        }else {
            //str已遍历到尾部，或者当前字符匹配失败，则直接返回false
            return false;
        }
    }

    public static void main(String[] args){
        match(new char[]{},new char[]{'.','*'});
    }

}
