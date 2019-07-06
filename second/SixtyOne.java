package com.company.second;

//序列化二叉树
public class SixtyOne {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //思路：
    //序列化其实可以看做对数进行遍历，只不过不同于一般的遍历，因为要反序列即还原树，所以我们需要在遍历的同时保存树的结构
    //通过保存叶子节点的方式，可以通过前序遍历实现二叉树的序列化与反序列化
    //因为序列化的值是按前序遍历的方式存的，所以反序列化也得按前序遍历的方式恢复。
    String Serialize(TreeNode root) {
        if (root == null){
            //叶子节点
            return "#,";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(root.val + ",");
        builder.append(Serialize(root.left));
        builder.append(Serialize(root.right));
        return builder.toString();
    }

    TreeNode Deserialize(String str) {
        String[] array = str.split(",");
        return Deserialize(array);
    }

    //index设为全局变量，不会在递归中回退
    int index = -1;
    private TreeNode Deserialize(String[] array) {
        index++;
        TreeNode treeNode = null;
        //字符串比较尽量用equals
        if (!"#".equals(array[index])){
            treeNode = new TreeNode(Integer.valueOf(array[index]));
            treeNode.left = Deserialize(array);
            treeNode.right = Deserialize(array);
        }
        return treeNode;
    }

}
