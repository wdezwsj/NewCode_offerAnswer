package com.company.second;

import java.util.ArrayList;
import java.util.PriorityQueue;

//最小的K个数
public class TwentyNine {

    //解法一，用冒泡排序，直接把最小的k个数冒出来
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k > input.length){
            return list;
        }
        //只冒k次
        for (int i = 0; i < k; i++){
            for (int j = i; j < input.length-1; j++){
                if (input[j] < input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
            list.add(input[input.length-i-1]);
        }
        return list;

    }

    //解法二，构造一个小顶推，然后逐一取堆顶的值放入数组后部（也就是将堆排序的的大顶堆换成小顶堆，并且只排k个数）
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k > input.length){
            return list;
        }
        //这里简单起见，直接用java内置的优先队列；
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++){
            queue.add(input[i]);
        }
        for (int j = 0; j < k; j++){
            list.add(queue.poll());
        }
        return list;
    }

    //最优解法
    //解法三，构造一个大小为k的大顶堆，当堆填满后，比较即将加入的值和堆顶的值谁更大，如果堆顶大，就移除堆顶的值，加入新值
    //这样能保证最后得到的大顶堆保存的一定是数组中最小的k个数。

}
