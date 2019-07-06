package com.company.second;

import java.util.ArrayList;

//把二叉树打印成多行
public class Sixty {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //思路：
    //从上到下按层打印二叉树，每层从左到右，参考上一题以及22题
    //需要借助一个辅助队列

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null){
            return result;
        }
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        ArrayList<Integer> valList = new ArrayList<>();
        nodeList.add(pRoot);
        valList.add(pRoot.val);
        result.add(valList);
        method(nodeList);
        return result;
    }

    private void method(ArrayList<TreeNode> nodeList) {
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<Integer> valList = new ArrayList<>();
        for (TreeNode node : nodeList){
            if (node.left != null){
                list.add(node.left);
                valList.add(node.left.val);
            }
            if (node.right != null){
                list.add(node.right);
                valList.add(node.right.val);
            }
        }
        if (valList.size() == 0){
            return;
        }
        result.add(valList);
        method(list);
    }

}
