package com.company.second;

//数组中的逆序对
public class ThirtyFive {

    //思路：
    //采用归并排序的思想，分块的进行逆序对查找，查找完块中的逆序对后对块内的数进行排序。
    //块与块之间数的的逆序关系不会随着块内部的排序而受影响。

    //如7,6,5,4
    //分块为7,6    5,4
    //7,6中有一个逆序对，排完序6,7； 5,4中有一个逆序对，排完序4,5
    //然后找(6,7)与(4,5)之间的逆序对，有7,5； 7,4； 6,5； 6,4四对
    //所以答案为1+1+4=6对。
    static int count = 0;
    static int[] cahce;
    public static int InversePairs(int [] array) {
        if (array == null || array.length <= 1){
            return 0;
        }
        cahce = new int[array.length];
        InversePairs(array,0,array.length-1);
        return count%1000000007;
    }

    private static void InversePairs(int[] array, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = (start + end)/2;
        //这里采用归并的思想，先分再合,在合的过程中寻找逆序对
        InversePairs(array,start,mid);
        InversePairs(array,mid+1,end);
        merge(array,start,mid,end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        //与归并排序不同的是，这里的左右指针从末端开始
        int left = mid, right = end;
        for (int i = end; i >= start; i--){
            if (left < start){
                cahce[i] = array[right];
                right--;
            }else if (right < mid+1){
                cahce[i] = array[left];
                left--;
            }else if (array[left] > array[right]){
                //左指针对应的值大于右指针对应的值，因为两边已经排过序，所以从mid+1到right之间的数与left全部构成逆序对
                count += right - mid;
                count = count%1000000007;
                cahce[i] = array[left];
                left--;
            }else{
                cahce[i] = array[right];
                right--;
            }
        }
        for (int j = start; j <= end; j++){
            array[j] = cahce[j];
        }
    }

    public static void main(String[] args){
        InversePairs(new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575});
//        InversePairs(new int[]{7,8,9,4,5,6});
    }


    //纯遍历的方法，时间复杂度O（n2），牛客编译报超时
//    public int InversePairs(int [] array) {
//        if (array == null || array.length <= 1){
//            return 0;
//        }
//        int count = 0;
//        for (int i = 0; i < array.length - 1; i++){
//            for (int j = i+1; j < array.length; j++){
//                if (array[i] > array[j]){
//                    count++;
//                }
//            }
//        }
//        return count % 1000000007;
//    }

}
