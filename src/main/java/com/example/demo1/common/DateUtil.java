package com.example.demo1.common;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    public  static String dateToFormatString(Date date,String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);

        return  sdf.format(date);
    }
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        String s1=dateToFormatString(date,"yyyy-MM-dd HH:mm:dd");
        System.out.println(s1);

    }
}
