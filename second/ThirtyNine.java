package com.company.second;

//平衡二叉树
public class ThirtyNine {

    //判断一个树是否是平衡二叉树，考点还是在树的深度
    //若左右子树的深度差超过1，就不是平衡二叉树
    //后序遍历能很好的满足对左右子树的比较
    //需要注意的是，若判断该树不平衡，则应该立马退出以节约时间
    public boolean IsBalanced_Solution(ThirtyEight.TreeNode root) {
        if (root == null){
            //空树也是平衡的
            return true;
        }
        return getDepth(root) != -1;
    }

    private int getDepth(ThirtyEight.TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1){
            return -1;
        }
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1){
            return -1;
        }
        if (Math.abs(rightDepth - leftDepth) > 1){
            return -1;
        }
        return Math.max(leftDepth,rightDepth) + 1;
    }

}
