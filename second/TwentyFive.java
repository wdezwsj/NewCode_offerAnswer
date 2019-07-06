package com.company.second;

//复杂链表的复制
public class TwentyFive {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //思路：
    //先在链表中复制每一个节点，如1-->2-->3-->4-->5，复制后，1-->1'-->2-->2'-->3-->3'-->4-->4'-->5-->5'
    //然后将原节点上的随机指针，拷贝到复制节点上，如原节点1.random = 3，那么复制节点1'.random = 3'
    //最后，将所有复制节点串成一个新的链表，即复制完成。1'-->2'-->3'-->4'-->5'
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null){
            return pHead;
        }
        RandomListNode cur1 = pHead;
        //第一步，原链表中插入复制节点
        while (cur1 != null){
            RandomListNode node = new RandomListNode(cur1.label);
            node.next = cur1.next;
            cur1.next = node;
            cur1 = node.next;
        }
        RandomListNode cur2 = pHead;
        //第二步，拷贝随机指针
        while (cur2 != null){
            RandomListNode copyNode = cur2.next;
            if (cur2.random != null){
                copyNode.random = cur2.random.next;
            }
            cur2 = copyNode.next;
        }
        //第三步，构建新链表
        //由于答案的bug，必须得还原原链表
        RandomListNode copyHead = pHead.next;
        RandomListNode cur3 = pHead;
        while (cur3 != null){
            RandomListNode copyNode = cur3.next;
            cur3.next = copyNode.next;
            if (copyNode.next != null){
                copyNode.next = copyNode.next.next;
            }
            cur3 = cur3.next;
        }
        return copyHead;

    }

}
