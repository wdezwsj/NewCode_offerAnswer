package com.company.second;

//数组中重复的数字
public class Fifty {

    //思路：
    //数组长度为n，数组内数字的大小范围为0~~~n-1
    //所以，若无重复的数，则每个下标和其对应的数组中的值应该是相等的。
    //通过一次遍历先判断输入的数组是否有效
    //然后遍历整个数组，当碰到下标和对应数组元素不相等时，我们便把该元素和他应该在的位置下标所对应的元素做交换，
    //这样我们就相当于把把这个元素给放置到了正确的位置，然后我们继续判断换过来的元素是否和当前下标对应，
    //若不对应，则继续重复上述步骤，直至换回来的元素正好对应当前下标。
    //若换的过程中发现当前下标对应的元素其应该在的位置上的元素和自己相等，那么这就是我们发现的第一个重复数字。
    //
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0){
            return false;
        }
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] < 0 || numbers[i] > length-1){
                //输入数组无效
                return false;
            }
        }
        //遍历数组
        for (int i = 0; i < numbers.length; i++){
            //判断当前下标和下标所对应元素的关系
            while (i != numbers[i]){
                //若下标和对应元素不相等，则准备将元素放置到正确的位置
                if (numbers[i] == numbers[numbers[i]]){
                    //重复了，得到结果
                    duplication[0] = numbers[i];
                    return true;
                }else {
                    //swap功能
                    int temp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        return false;
    }

}
