package com.company.second;

//二叉搜索树的第k个节点
public class SixtyTwo {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //思路：
    //找二叉搜索树中第k小的节点，首先明确二叉搜索树的中序遍历得到的结果就是升序排列
    //所以直接进行中序遍历，计数到k时的节点即为答案

    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot != null){
            TreeNode node = KthNode(pRoot.left, k);
            if(node != null) {
                return node;
            }
            //计数
            index ++;
            if(index == k) {
                //第k节点返回
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if(node != null) {
                return node;
            }
        }
        //在不满足index == k的条件下，代码都会走到这一步并返回null
        return null;
    }

}
