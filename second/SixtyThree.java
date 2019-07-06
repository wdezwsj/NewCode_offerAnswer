package com.company.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//数据流中的中位数
public class SixtyThree {

    //思路：
    //最简单的方法，就是用数组保存输入的数据，并在取数据时对数据进行排序，然后取中位数
    //然而，我们会发现在每次取数据时进行全排序操作是极度浪费时间的
    //所以改进的方法是在获取数据流时采取插入排序的方法把新的数据放入数组中，这样插入需要On的时间复杂度，取中位数只要O1的时间复杂度

    //在插入的时间复杂度上还能进行改进，将普通的数组换成两个堆，大顶堆用于存放较小的数，小顶堆用于存放较大的数
    //在每次插入时只需要通过比较插入数据和两堆顶的大小就能决定插入哪个堆
    //由于堆的大小只有n/2，所以此时插入的时间复杂度只有log(n/2)，远小于n 。

    //-------------------------------------------------------------------------------------------------------------------
//    //暴力法
//    ArrayList<Integer> list = new ArrayList<>();
//    public void Insert(Integer num) {
//        list.add(num);
//    }
//
//    public Double GetMedian() {
//        Collections.sort(list);
//        if (list.size() % 2 == 0){
//            double a = (double)list.get((list.size()-1)/2);
//            double b = (double)list.get(list.size()/2);
//            return (a+b)/2;
//        }else {
//            return (double) list.get(list.size()/2);
//        }
//    }
    //--------------------------------------------------------------------------------------------------------------------

    //大小顶堆法
    //默认是小顶堆，即堆顶为最小值
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //大顶堆把比较器反转即可
            return o2.compareTo(o1);
        }
    });
    //总计数
    int count = 0;
    public void Insert(Integer num) {
        count++;
        //这里规定奇数插大顶堆，偶数插小顶堆
        //记住一个原则，大顶堆里放小值，小顶堆里放大值，小顶堆中的所有值都大于大顶堆
        if ((count & 1) == 1){
            if (!minQueue.isEmpty() && num > minQueue.peek()){
                //如果要放入大顶堆里的值比小顶堆中的最小值还要大，那么这个值应该放入小顶堆中，并把小顶堆的最小值放进大顶堆中
                int temp = minQueue.poll();
                minQueue.add(num);
                num = temp;
            }
            maxQueue.add(num);
        }else {
            if (!maxQueue.isEmpty() && num < maxQueue.peek()){
                //如果要放入小顶堆里的值比大顶堆中的最大值还要小，那么这个值就应该放入大顶堆中，并把大顶堆中的最大值放进小顶堆中
                int temp = maxQueue.poll();
                maxQueue.add(num);
                num = temp;
            }
            minQueue.add(num);
        }
    }

    public Double GetMedian() {
        if ((count & 1) == 1){
            return (double) maxQueue.peek();
        }
        double a = minQueue.peek();
        double b = maxQueue.peek();
        return (a + b) / 2;
    }

}
