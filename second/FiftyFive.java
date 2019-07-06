package com.company.second;

//链表中环的入口结点
public class FiftyFive {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //思路：
    //解法一，用一个HashSet记录所有路过的节点，第一个重复的即为环的入口

    //解法二，一快一慢两个指针（两倍速关系），当两指针相遇时，其中一指针返回头节点，另一针待在相遇点，然后两指针以同样的一倍速前进。
    //原理，设该链表中非环部分长为x，环的长度为y，环的总长度为x+y，相遇点距离环的入口距离为k，快指针在环中循环了n圈
    //则存在如下关系 2(x+k) = x+k+ny , 即 x = ny - k
    //所以，从相遇点开始前进 x 等效于从相遇点前进 ny -k 的距离，又因为相遇点距离环入口的距离为k，
    //可以看做起始点为k，前进距离为ny - k，那么k +（ny - k）= ny ，即从相遇点前进非环部分的长度x，一定会停在环的入口处。
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return null;
        }
        ListNode p1 = pHead.next;
        ListNode p2 = pHead.next.next;
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p1 = pHead;
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


}
