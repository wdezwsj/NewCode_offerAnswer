package com.company.others;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

//
public class One {

    public static String method(ArrayList<Integer> listByte, ArrayList<Integer> listDance) {
        ArrayList<Integer> list = new ArrayList<>();
        int sumByte = 0, sumDance = 0;
        while (!listByte.isEmpty() && !listDance.isEmpty()){
            //Byte出牌
            int x = listByte.remove(0);
            if (!list.isEmpty() && list.contains(x)){
                int index = list.indexOf(x);
                int size = list.size();
                sumByte += size - index + 1;
                for (int i = 0; i < size - index; i++){
                    list.remove(list.size()-1);
                }
            }else {
                list.add(x);
            }
            //Dance出牌
            int y = listDance.remove(0);
            if (!list.isEmpty() && list.contains(y)){
                int index = list.indexOf(y);
                int size = list.size();
                sumDance += size - index + 1;
                for (int i = 0; i < size - index; i++){
                    list.remove(list.size()-1);
                }
            }else {
                list.add(y);
            }
        }
        //如果Byte牌出完了
        if (listByte.size() == 0){
            while (!listDance.isEmpty()){
                int y = listDance.remove(0);
                if (!list.isEmpty() && list.contains(y)){
                    int index = list.indexOf(y);
                    int size = list.size();
                    sumDance += size - index + 1;
                    for (int i = 0; i < size - index; i++){
                        list.remove(list.size()-1);
                    }
                }else {
                    list.add(y);
                }
            }
        }
        //如果Dance牌出完了
        if (listDance.size() == 0){
            while (!listByte.isEmpty()){
                int x = listByte.remove(0);
                if (!list.isEmpty() && list.contains(x)){
                    int index = list.indexOf(x);
                    int size = list.size();
                    sumByte += size - index + 1;
                    for (int i = 0; i < size - index; i++){
                        list.remove(list.size()-1);
                    }
                }else {
                    list.add(x);
                }
            }
        }
        if (sumByte > sumDance){
            return "Byte";
        }else if (sumByte == sumDance){
            return "Draw";
        }else {
            return "Dance";
        }
    }

    public static void main(String[] args){
        int[] arr1={10, 2, 5, 6, 13, 11, 11, 4, 10, 8, 12, 5, 4, 1, 8, 1, 7, 12, 4, 13, 6, 9, 9, 9, 5, 7};

        int[] arr2={6 ,3, 13, 8, 2, 3 ,7, 3 ,2 ,2, 12, 11, 10, 6, 10, 1, 1, 12, 3, 5 ,7 ,11, 13, 4, 8, 9};
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++){
            list1.add(arr1[i]);
            list2.add(arr2[i]);
        }
        method(list1,list2);

    }
}
