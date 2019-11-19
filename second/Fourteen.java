package com.company.second;

import java.util.ArrayList;
import java.util.List;

//链表中倒数第k个节点
public class Fourteen {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //思路：
    //①暴力方法，直接用一个辅助队列暂存链表元素，返回倒数第k个即可
    //
    //②双指针法，i和j两个指针一开始都在链表头结点，让i先走k-1步，
    //然后从i的第k步开始，j也从头结点开始同步前进，
    //那么，当i到达到达链表尾时，j所处的结点正好就是链表中倒数第K个结点

    //增加了空间复杂度，只用一遍循环
    public ListNode FindKthToTail(ListNode head,int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        if (list.size() - k < 0 || k <= 0){
            return null;
        }
        return list.get(list.size()-k);
    }

    //不开辟额外的空间
    //两个指针，先让第一个指针走k步，然后两个指针一起走，直到第一个指针走到空节点处，那么后走的指针就是倒数第K个节点
    //因为两个指针的距离差始终为k
    //该方法和直接先走到末尾确定链表总长度n，再从头走到n-k+1处节点所耗时间是相同的
    public ListNode FindKthToTail2(ListNode head,int k) {
        ListNode p = head;
        ListNode q = head;
        int i = 0;
        for (;p != null; i++){
            if (i >= k){
                q = q.next;
            }
            p = p.next;
        }
        return i < k ? null : q;
    }

}
