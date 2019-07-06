package com.company.second;

import java.util.ArrayList;

//滑动窗口的最大值
public class SixtyFour {

    //思路：
    //暴力法，对每个窗口内部都进行一次遍历比较大小，时间复杂度O(n2)

    //仔细研究可以发现，并不需要对每个窗口都进行遍历来比较大小，
    //若上一窗口的最大值在下一窗口中依然有效且大于下一窗口新进来的值，
    //那么下一窗口的最大值依然是上一窗口的最大值
    //所以我们可以采用一个队列来保存当前窗口中最大值的索引
    //具体步骤为：
    //每当窗口右移一位，我们就判断该队列中队首元素即上一窗口最大值的索引是否已经出界
    //若出界，则应剔除该元素。然后往队尾加入窗口右移所产生的新的元素，
    //若该元素大于其前一元素所指向的值，则将其前一元素剔除掉，直到该元素小于等于前一元素所指向的值
    //由此，本次窗口的辅助队列就已排好，往result中添加队首元素即可。
    //重复上述步骤直至遍历到数组末尾。
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> assistList = new ArrayList<>();
        if (size <= 0 || num.length < size){
            return result;
        }

        //这个i代表窗口的尾部索引，所以是从0到num.length-1
        for (int i = 0; i < num.length; i++){
            //先判断最大值是否失效
            if (!assistList.isEmpty() && assistList.get(0) <= i-size){
                assistList.remove(0);
            }
            //再循环剔除新值插入后其前面较小的值
            while (!assistList.isEmpty() && num[i] > num[assistList.get(assistList.size()-1)]){
                assistList.remove(assistList.size()-1);
            }
            assistList.add(i);
            //最后添加到result中
            if (i >= size-1){
                result.add(num[assistList.get(0)]);
            }
        }
        return result;
    }

    public static void main(String[] args){
        maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
        //该测试用例对应的assistList结构为：
        //2  -->  3  --> 4 -->  4,2  -->  6  -->  6,2  -->  6,5  -->  5,1
        //该测试用例对应的result结构为：
        //               4    ,   4    ,  6    ,   6     ,   6     ,   5
    }

}
