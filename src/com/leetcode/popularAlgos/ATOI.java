package com.leetcode.popularAlgos;

public class ATOI {

    public static int myAtoi(String str) {
        if(str == null || str.equals("")){
            return 0;
        }
        int sign =1, i =0, total = 0;

        while(str.charAt(i) == ' '){
            i++;
        }
        if(str.charAt(i) == '-' || str.charAt(i) == '+'){
            sign =  1- 2* (str.charAt(i) == '-' ? 1 : 0);
            i++;
        }
        while(i < str.length() && (str.charAt(i) >= '0'  && str.charAt(i) <= '9')){
            if(total > Integer.MAX_VALUE/10 || (total == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > 7)){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total*10 + (str.charAt(i++) - '0');
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println(ATOI.myAtoi("2147483648"));
        int a = 3;
        int b = 4;
        System.out.println((a+b)/2);
    }
}
