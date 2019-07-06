package com.company.second;

//二叉树的深度
public class ThirtyEight {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //思路：
    //遇到树的路径相关的题，优先考虑前序遍历，前序遍历是天然的深度优先遍历
    //遇到叶节点，则用当前深度和最大值进行一次比较
    //注意，回退时记得将当前深度减一
    int max = 0;
    int temp = 0;
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        temp++;
        if (root.left == null && root.right == null){
            //当前节点为叶节点，比较当前深度与最大深度，然后回退并将深度减一
            max = Math.max(max,temp);
            return temp--;
        }
        TreeDepth(root.left);
        TreeDepth(root.right);
        //当前节点的左右子树都遍历完了，在回退到父节点前，将深度值减一
        temp--;
        return max;
    }

    //思路：
    //采用后序遍历更简单！
    //原理，父节点的深度等于左右子树中深度较大的值+1
    public int TreeDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = TreeDepth2(root.left);
        int rightDepth = TreeDepth2(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }


//    public static void main(String[] args){
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(6);
//        TreeNode treeNode7 = new TreeNode(7);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.right = treeNode6;
//        treeNode5.left = treeNode7;
//        TreeDepth(treeNode1);
//    }

}
