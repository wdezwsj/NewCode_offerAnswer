package com.company.second;

import java.util.ArrayList;
import java.util.Vector;

//按之字形顺序打印二叉树
public class FiftyNine {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //思路：
    //利用标志位实现之字形打印，要么从左往右，要么从右往左
    //需要一个辅助栈来保存上一轮打印的Node

    //标志位
    boolean flag = false;
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    //复用一个valList
    ArrayList<Integer> valList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null){
            return result;
        }
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(pRoot);
        valList.add(pRoot.val);
        result.add(new ArrayList<Integer>(valList));
        valList.clear();;
        flag = !flag;
        method(nodeList);
        return result;
    }

    public void method(ArrayList<TreeNode> list){
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        for (TreeNode treeNode : list){
            if (treeNode!=null){
                if (flag){
                    //从右往左
                    nodeList.add(0,treeNode.right);
                    nodeList.add(0,treeNode.left);
                }else {
                    //从左往右
                    nodeList.add(0,treeNode.left);
                    nodeList.add(0,treeNode.right);
                }
            }
        }
        for (int i = nodeList.size()-1; i >= 0; i--){
            if (nodeList.get(i) != null){
                valList.add(nodeList.get(i).val);
            }
        }
        if (valList.size() == 0){
            return;
        }
        result.add(new ArrayList<Integer>(valList));
        valList.clear();
        flag = !flag;
        method(nodeList);
    }

}
