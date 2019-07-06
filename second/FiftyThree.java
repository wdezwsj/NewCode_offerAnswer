package com.company.second;

//表示数值的字符串
public class FiftyThree {

    //思路：
    //没什么技术上的难点，关键是整数、小数和指数部分的关系要弄清楚（我也不知道哪来这么奇葩的规则）
    //整数部分可以没有如 .123
    //小数部分可以没有值如 123.
    //指数不能单独存在，且指数部分若存在，则必须有整形值如 1e2
    //符号位只能出现在整数和指数部分
    //按照上面限定的规则，从头到尾遍历即可

    //str的游标，从头开始
    int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null){
            return false;
        }
        //判断整数是否存在
        boolean flag = scanInteger(str);
        //判断是否存在小数点
        if (index < str.length && str[index] == '.'){
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        //判断是否存在e或E字符
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')){
            index++;
            flag = flag && scanInteger(str);
        }
        //最后要判断index是否扫描完了整个str
        return flag && (index == str.length);
    }

    //用来判断有符整形数，判断完符号位后还是调用的判断无符整形数的方法
    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') ) {
            //判断当前位是否是符号位
            index++;
        }
        return scanUnsignedInteger(str);
    }

    //判断无符整形数
    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        //index大于起始下标代表该整形数存在
        return start < index;
    }

}
