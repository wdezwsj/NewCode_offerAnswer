package com.company.second;

import java.util.Stack;

//用两个栈实现队列
public class Five {

    //思路：
    //stack1用来存储push进来的元素
    //每当要取元素时，先判断stack2中有没元素
    //若stack2中无元素的话，则将stack1中的元素顺序弹出并压入stack2中，这样stack1中先入的数据就能位于stack2的栈顶，返回stack2栈顶的值即可
    //若stack2中有元素的话，就代表上次从stack1往stack2中转入的数据还没有取完，则直接取stack2中栈顶元素即可；

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
