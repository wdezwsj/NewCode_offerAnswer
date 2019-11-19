package com.company.others;

import java.util.ArrayList;

//判断是不是完全二叉树
public class CompleteBTree {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 完全二叉树的定义：除了最后一层可能不是”满的“，其它层都必须是”满的“，且最后一层的结点都在左边连续出现。
     * @param root
     * @return
     */
    public boolean judgeCompleteBTree(TreeNode root){
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() != 0){
            TreeNode node = list.remove(0);
            if (node == null){
                if (list.size() !=0 ){
                    //node为空且此刻list还有值没取完
                    return false;
                }else {
                    return true;
                }
            }
            if (node.left != null || node.right != null){
                //只要node不是叶子节点，就往list里添加它的左右孩子
                list.add(node.left);
                list.add(node.right);
            }
        }
        return true;
    }

}
