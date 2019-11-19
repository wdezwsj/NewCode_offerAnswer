package com.company.second;

//树的子结构
public class Seventeen {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //思路：
    //要判断是不是树的子结构，首先通过遍历主树找到比对的起始点（哪种遍历都可以，代码中采用的前序遍历）
    //具体的比对过程：比较root1和root2是否为null，若root2为null，则表示需要被比对的树已经被完整的全部比对了，所以返回true；
    //若root2不为null而root1为null，则表示主树比对到尽头了还没完成比对，则必定不是子结构；
    //若root1和root2都不为null，那么就比较二者的value是否相等，不相等就返回false；
    //相等的话，就继续比较root1的左结点与root2的左结点 以及 root1的右结点与root2的右结点。

    //树的子结构即树的一部分
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        //首先遍历树，寻找子结构比较的起始点
        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                result = isSubtree(root1,root2);
            }
            //分别遍历左右子树
            if (!result){
                result = HasSubtree(root1.left,root2);
            }
            if (!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    //以当前节点为根，逐一比较当前节点及其左右子树的值是否相等
    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null){
            //如果root2遍历完了，说明root2就是root1的子结构
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        //比较root1和root2的左子结构和右子结构时候相等
        //短路与还能有助于在左子树已确定不是子结构的时候提前退出
        return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);
    }

}
