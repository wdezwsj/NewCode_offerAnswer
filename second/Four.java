package com.company.second;

//重建二叉树
public class Four {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //思路：
    //根据二叉树的前序遍历和中序遍历来还原二叉树，那么我们就要了解前序遍历和中序遍历的特点
    //前序遍历序列{1,2,4,7,3,5,6,8} 中序遍历序列{4,7,2,1,5,3,8,6}
    //前序遍历序列中的第一个元素即为root节点，通过确定root节点在中序遍历中的位置，即可以得到左子树的前序和中序遍历以及右子树的前序和中序遍历
    //如首先通过前序遍历序列的首元素得知root为1,然后在中序遍历序列中找到1对应的位置，随后可以就能得到
    //左子树的前序和中序遍历{2，4，7}{4，7，2}，右子树的前序和中序遍历{3，5，6，8}{5，3，8，6}
    //然后再对左子树和右子树重复上面的操作即可。
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || pre.length != in.length){
            return null;
        }
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode reConstructBinaryTree(int [] pre, int a, int b,int [] in, int c, int d) {
        if (a > b){
            return null;
        }
        int rootVal = pre[a];
        TreeNode root = new TreeNode(rootVal);
        int i = c;
        for (; i <= d; i++){
            if (in[i] == rootVal){
                break;
            }
        }
        root.left = reConstructBinaryTree(pre,a+1,a+i-c,in,c,i-1);
        root.right = reConstructBinaryTree(pre,a+i-c+1,b,in,i+1,d);
        return root;

    }


}
