package com.company.second;

import java.util.ArrayList;

//二叉树中和为某一值的路径
//该路径的定义为从根节点开始一直到叶节点所形成的一条路径
public class TwentyFour {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> cache = new ArrayList<>();

    //思路：
    //由于路径的定义，所以采取前序遍历的方式，天然的形成从根节点到叶节点的路径，然后逐一判断
    //需要注意的是，递归回退时，要删除掉暂存的当前访问节点
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root != null){
            cache.add(root.val);
            target -= root.val;
            if (target == 0 && root.left == null && root.right == null){
                //满足路径的条件，target减到0，root为叶节点
                result.add(new ArrayList<>(cache));
            }else {
                FindPath(root.left,target);
                FindPath(root.right,target);
            }
            //回退
            cache.remove(cache.size()-1);
        }
        return result;
    }

}
