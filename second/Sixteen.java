package com.company.second;

//合并两个排序的链表
public class Sixteen {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //思路：
    //看成归并排序的merge过程
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                temp.next = list2;
                list2 = list2.next;
            }else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        if (list1 == null){
            temp.next = list2;
        }else {
            temp.next = list1;
        }
        return head.next;
    }

}
