package com.company.second;

import java.util.ArrayList;

//把字符串转换成整数
public class FourtyNine {

    //思路：
    //首先考虑是否有符号
    //然后逐个比对字符，通过与'0'和'9'的对比能将该字符转换为数字
    //最后把数字组合起来，别忘了符号位
    public int StrToInt(String str) {
        if (str == null || str.length() == 0){
            return 0;
        }
        int index = 0;
        boolean flag = true;
        ArrayList<Integer> list = new ArrayList<>();
        //判断正负
        if (str.charAt(index) == '-'){
            flag = false;
            index++;
        }else if (str.charAt(index) == '+'){
            index++;
        }
        //开始遍历字符串
        for (; index < str.length(); index++){
            char x = str.charAt(index);
            if (x >= '0' && x <= '9'){
                list.add(x - '0');
            }else {
                return 0;
            }
        }
        //构造数字
        int result = 0;
        for (int i = 0; i < list.size(); i++){
            result = result*10 + list.get(i);
        }
        return flag? result: -result;
    }

}
