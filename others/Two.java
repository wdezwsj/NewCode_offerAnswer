package com.company.others;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Two {

    public static void method(String goal){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthData = simpleDateFormat.parse("2012-3-12");
            Date goalData = simpleDateFormat.parse(goal);
            long time = goalData.getTime() - birthData.getTime();
            System.out.println(time/(24*60*60*1000));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        method("2012-3-13");
    }

}
