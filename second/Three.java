package com.company.second;

import java.util.ArrayList;

//丛尾到头打印链表
public class Three {

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    //思路：
    //从尾到头返回一个ArrayList，直接往list里面头插就行了
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null){
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

}
