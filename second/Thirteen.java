package com.company.second;

//调整数组顺序使奇数位于偶数前面
public class Thirteen {

    //思路：
    //①借助一个辅助数组，在第一次遍历过程中复制原数组的数据，并计算出奇数的个数
    //根据奇数的个数，我们就能确定奇数和偶数在数组中的起始点
    //然后再经过一次遍历，把奇数和偶数放进去。

    //②因为要保证相对顺序不变，我们可以用冒泡排序的思想来实现
    //如果当前数为偶数，下一个数为奇数，那么就将二者交换，

    //时间复杂度O(n)，空间复杂度O(n)
    public void reOrderArray(int [] array) {
        if (array != null){
            int jishu = 0;
            int[] copy = new int[array.length];
            for (int i = 0; i < array.length; i++){
                if (array[i] % 2 != 0){
                    jishu++;
                }
                copy[i] = array[i];
            }
            int x = 0, y = jishu;
            for (int j = 0; j < array.length; j++){
                if (copy[j] % 2 != 0){
                    array[x] = copy[j];
                    x++;
                }else {
                    array[y] = copy[j];
                    y++;
                }
            }
        }
    }

    //方法二，类似冒泡法，时间复杂度O(n2)，空间复杂度O(1)
    public void reOrderArray2(int [] array) {
        if (array != null){
            for (int i = array.length; i > 0; i--){
                for (int j = 0; j < i-1; j++){
                    //如果当前位为偶数，下一位为奇数，则交换
                    if ((array[j] & 1) == 0 && (array[j+1] & 1) == 1){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
        }
    }

}
