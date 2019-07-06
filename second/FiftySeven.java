package com.company.second;

//二叉树的下一个结点
public class FiftySeven {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    //思路：
    //首先要熟悉中序遍历的特性，左子树-->根-->右子树，所以当前节点的左子树一定是已经遍历完了的。
    //那么
    //①先判断当前节点是否存在右子树，若右子树存在，则下一结点为右子树的最左叶子节点
    //②若不存在右子树，则说明以当前节点为根的子树已遍历完，接着需要要往上遍历，
    //那么就寻找当前节点的父节点，③如父节点不存在，则return null
    //④若父节点存在，那么要判断当前节点与其父节点的关系
    //若当前节点是父节点的左孩子，那么return 父节点
    //若当前节点是父节点的右孩子，那么我们就需要继续向上遍历，把父节点当做当前节点，重复③④的过程。
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null){
            return null;
        }

        if (pNode.right != null){
            //对应①
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }else {
            //对应②
            while (true){
                TreeLinkNode father = pNode.next;
                if (father == null){
                    //对应③
                    return null;
                }else if (father.left == pNode){
                    //对应④
                    return father;
                }else {
                    pNode = father;
                }
            }
        }
    }

}
