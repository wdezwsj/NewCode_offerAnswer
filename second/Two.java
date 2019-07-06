package com.company.second;

//替换空格
public class Two {

    //思路：
    //遍历一遍给定的str，将" "全部替换为"%20"即可
    public String replaceSpace(StringBuffer str) {
        if (str == null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String srcStr = str.toString();
        for (int i = 0; i < srcStr.length(); i++){
            if (srcStr.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(srcStr.charAt(i));
            }
        }
        return stringBuilder.toString();
    }


    //投机取巧的写法
    public String replaceSpace2(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

}
