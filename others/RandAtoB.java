package com.company.others;

public class RandAtoB {

    //RandA能等概率返回[1,A]
    //RandB能等概率返回[1,B]
    public static void main(String[] args){

    }

    public static int randA(){
        return 1;
    }
    //由RandA实现RandB的效果
    public static int convert(int a, int b){
        int x;
        if (a >= b){
            do {
                x = randA();
            }while (x > b);
            return x;
        }else {
            do {
                x = a * (randA()-1) + randA();
            }while (x > b);//这里可以改为k*b
            return x%b + 1;
        }
    }


}
