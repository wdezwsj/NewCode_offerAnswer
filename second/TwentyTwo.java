package com.company.second;

import java.util.ArrayList;

//从上往下打印二叉树
//同层节点从左往右打印
public class TwentyTwo {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //思路：         1
    //           2      3
    //        4    5  6   7
    //借助一个队列来实现
    //队列的状态如下，
    // 1 --> 2,3 --> 3,4,5 --> 4,5,6,7 --> 5,6,7 --> 6,7 --> 7 --> empty
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        //以队列的形式存储树每一层的节点
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            //队列不为空，就取首元素，并将左右子节点加入队尾
            TreeNode node = queue.remove(0);
            result.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return result;
    }

}
