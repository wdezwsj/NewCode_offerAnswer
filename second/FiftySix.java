package com.company.second;

//删除链表中重复的节点
public class FiftySix {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //思路：
    //例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    //因为本题不仅要求删除重复的节点，还要求不保留该节点，
    //所以，我们在遍历的过程中需要保存上一节点
    //其次，由于头节点也可能会和后面的节点重复，
    //所以，我们要构造一个虚拟节点，从虚拟节点开始遍历
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        //在head之前构建一个虚拟节点
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = pHead;

        //两个变量，一个记录上一节点，一个记录比较节点
        ListNode currentNode = virtualNode;
        ListNode nextNode = pHead;

        while (nextNode != null && nextNode.next != null){
            if (nextNode.val == nextNode.next.val){
                while (nextNode.next != null && nextNode.val == nextNode.next.val){
                    nextNode = nextNode.next;
                }
                currentNode.next = nextNode.next;
            }else {
                currentNode = currentNode.next;
            }
            nextNode = nextNode.next;
        }
        return virtualNode.next;
    }

}
