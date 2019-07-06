package com.company.second;

import java.util.Stack;

//栈的压入、弹出序列
public class TwentyOne {

    //思路：
    //给定一个栈的压入序列，判断该弹出序列是否可能存在
    //我们用一个栈来还原入栈出栈操作，每次入栈后都要判断该入栈的元素会不会对应着出栈的操作
    //正确比对的结果应该是该栈最终为空，否则返回false
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //辅助栈
        Stack<Integer> stack = new Stack<>();
        //出栈数组的下标
        int index = 0;
        //模拟入栈过程
        for (int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[index]){
                //模拟出栈过程
                stack.pop();
                index++;
            }
        }
        //栈内无元素，表示出栈与入栈的过程匹配成功
        return stack.empty();
    }

}
