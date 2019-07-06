package com.company.second;

//两个链表的第一个公共节点
public class ThirtySix {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //思路：
    //先遍历两个链表，得出二者的长度
    //然后长度相减得到长度差值
    //再让较长的链表从头开始先前进差值的步数，随后二者一起前进，一边前进一边比较二者链表上的当前节点是否相等
    //第一个相等的节点即为第一个公共节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        //遍历两个链表，求两个链表的长度
        int p1Length = 0;
        ListNode a = pHead1;
        while (a != null){
            p1Length++;
            a = a.next;
        }
        ListNode b = pHead2;
        int p2Length = 0;
        while (b != null){
            p2Length++;
            b = b.next;
        }
        //求两个链表的长度差，然后让长的链表先前进差值的步数
        int gap = p1Length - p2Length;
        if (gap < 0){
            gap = -gap;
            while(gap > 0){
                pHead2 = pHead2.next;
                gap--;
            }
        }else {
            while(gap > 0){
                pHead1 = pHead1.next;
                gap--;
            }
        }
        //最后共同前进，一边前进一边比较节点是否相等
        while (pHead1 != null){
            if (pHead1 == pHead2){
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

}
