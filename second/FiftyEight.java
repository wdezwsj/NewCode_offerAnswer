package com.company.second;

//对称的二叉树
public class FiftyEight {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //思路：
    //自己创造一个和前序遍历 相对称 的遍历方法，两个方法每取一个点就进行比较，中途比较出错就返回false
    boolean isSymmetrical(TreeNode pRoot) {
        return method(pRoot,pRoot);
    }

    boolean method(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null | right == null){
            return false;
        }else if (left.val == right.val){
            //前序遍历是根-->左子树-->右子树，相对称的遍历是根-->右子树-->左子树
            return method(left.left,right.right) && method(left.right,right.left);
        }else {
            return false;
        }
    }


}
