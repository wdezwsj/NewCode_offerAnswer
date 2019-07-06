package com.company.second;

import java.util.Stack;

//包含min函数的栈
public class Twenty {

    public Stack<Integer> data = new Stack<>();
    public Stack<Integer> minData = new Stack<>();

    //思路：
    //既然要求min()方法的时间复杂度为O(1)，那么就要在push的时候做完所有的操作
    //借助两个栈来实现，一个栈存储原始数据，一个栈存储当前栈内最小的值
    //例子，date：4 6 5 6 3 9 5 8 1 9 2 3
    //    minDta：4 4 4 4 3 3 3 3 1 1 1 1

    public void push(int node) {
        data.push(node);
        if (minData.empty()){
            minData.push(node);
        }else {
            if (minData.peek() <= node){
                minData.push(minData.peek());
            }else {
                minData.push(node);
            }
        }
    }

    public void pop() {
        data.pop();
        minData.pop();
    }

    public int top() {
        return data.peek();
    }

    //该方法时间复杂度要求为O(1)
    public int min() {
        return minData.peek();
    }

}
