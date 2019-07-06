package com.company.second;

//二叉搜索树与双向链表
public class TwentySix {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //    思路：
//            1.将左子树构造成双链表，并返回链表头节点。
//            2.定位至左子树双链表最后一个节点。
//            3.如果左子树链表不为空的话，将当前root追加到左子树链表。
//            4.将右子树构造成双链表，并返回链表头节点。
//            5.如果右子树链表不为空的话，将该链表追加到root节点之后。
//            6.根据左子树链表是否为空确定返回的节点。

    //该方法的作用：将pRootOfTree为根节点的树转换为双向链表并返回链表头节点
    //结束条件：遇到叶节点就直接返回叶节点
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        //1.返回左子树构造的双向链表的头节点
        TreeNode leftHead = Convert(pRootOfTree.left);
        TreeNode leftEnd = leftHead;
        //2.寻找左子树构造的双向链表的尾节点
        while (leftEnd != null && leftEnd.right != null){
            leftEnd = leftEnd.right;
        }
        //3.左子树的尾节点与根节点相连
        if (leftHead != null){
            leftEnd.right = pRootOfTree;
            pRootOfTree.left = leftEnd;
        }
        //4.返回右子树构造的双向链表的头节点
        TreeNode rightHead = Convert(pRootOfTree.right);
        //5.右子树的头节点与根节点相连
        if (rightHead != null){
            pRootOfTree.right = rightHead;
            rightHead.left = pRootOfTree;
        }
        //6.左子树若不为空，则返回左子树的头节点
        return leftHead != null ? leftHead : pRootOfTree;
    }

}
