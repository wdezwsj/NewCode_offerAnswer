package com.company.second;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//字符流中第一个不重复的字符
public class FiftyFour {

    //思路：
    //用LinkedHashMap来保存数据，既能记录数据的插入次数，又能记录数据插入的次序
    //字符流输入时，往map中add数据
    //查第一个不重复的数时，遍历map中的元素即可。

    LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (linkedHashMap.containsKey(ch)){
            linkedHashMap.replace(ch,linkedHashMap.get(ch)+1);
        }else {
            linkedHashMap.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Set<Map.Entry<Character, Integer>> set = linkedHashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : set){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return '#';
    }

}
