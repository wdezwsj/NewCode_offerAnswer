package com.company.second;

//二叉树的镜像
public class Eighteen {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //思路：
    //              8                                8
    //          6       10       ----->        10         6
    //       5    7   9    11               11    9    7     5
    //
    //将每一个结点的左右子结点互换就可以实现
    public void Mirror(TreeNode root) {
        if (root != null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            Mirror(left);
            Mirror(right);
        }
    }

}
