package com.company.second;

//二叉搜索树的后续遍历序列
public class TwentyThree {

    //思路：
    //后序遍历二叉搜索树的特点，从数组中第一个比root大的点开始，后面所有的点都必须比root大，如此划分出左右子树
    //然后左右子树必须也满足上述特点
    //如此便形成递归
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }
        //长度为2，两种情况，一大一小，对应root和右结点；一小一大，对应root和左结点
        //所以可以直接返回true
        if (sequence.length <= 2){
            return true;
        }
        //后序遍历的最后一个节点即是root节点
        return judge(sequence,0,sequence.length-1);
    }


    private boolean judge(int[] sequence, int start, int rootIndex) {
        if (start >= rootIndex){
            return true;
        }
        int root = sequence[rootIndex];
        //第一个比root节点大的点的下标
        int tempIndex = start;
        while (tempIndex < rootIndex && sequence[tempIndex] < root){
            tempIndex++;
        }
        //证明在第一个比root大的节点的右边所有节点都大于root节点
        for (int i = tempIndex + 1; i < rootIndex; i++){
            if (sequence[i] < root){
                return false;
            }
        }
        //再证明左右两子树是否也满足该特性
        return judge(sequence,start,tempIndex-1) && judge(sequence,tempIndex,rootIndex-1);
    }

}
