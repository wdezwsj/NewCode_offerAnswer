package com.company.second;

//反转链表
public class Fifteen {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //思路：
    //对于每一结点的操作涉及三个指针，一个指向上一个结点pre，一个指向自身current，一个指向下一结点next
    //每一次反转就是对这三个指针进行操作
    //首先，获取当前节点的下一节点；然后，将当前节点的下一节点指向其上一节点；
    //最后将pre指针指向当前结点，将current指针指向下一结点，如此便完成了一个结点的反转
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while(current != null){
            //提前取出当前节点的下一节点
            ListNode next = current.next;
            //当前节点的下一节点指针指向上一节点
            current.next = pre;
            //上一节点的指针指向当前节点
            pre = current;
            //当前节点的指针指向下一节点
            current = next;
        }
        return pre;
    }

}
