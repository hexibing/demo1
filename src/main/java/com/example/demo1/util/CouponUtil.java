package com.example.demo1.util;


import java.util.Arrays;
import java.util.Random;

public class CouponUtil {


    public static final String ALLCHAR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String numberArray[] = {"0","1","2","3","4","5","6","7","8","9"};

    public static final String stringsArray[] = {"A","B","C","D","E","F","G","H","I","J"
            ,"K","L","M","N","O","P","Q","R","S"
            ,"T","U","V","W","X","Y","Z"};


    public static String getChar(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < 7; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return  sb.toString();
    }


    public static   String getCode(){
        String s= getChar();
        int sum=0;
        int numSum=0;
        for(int i = 0; i < s.length(); i++) {
            String indexValue=s.substring(i,i+1);
            if (Arrays.asList(stringsArray).contains(indexValue)){
                char[] charArry =indexValue.toCharArray();
                for(int c:charArry){
                    sum=c+sum;
                }
            }
            else {
                numSum+=Integer.parseInt(indexValue);
            }
        }
        return  s+""+(sum+numSum)%10;
    }



}
