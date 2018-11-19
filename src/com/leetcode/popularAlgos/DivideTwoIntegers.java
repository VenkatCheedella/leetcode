package com.leetcode.popularAlgos;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }

        if(dividend == 0){
            return 0;
        }
        int count = 1;
        long didend = (long) dividend;
        long disor = (long) divisor;

        return helper(didend, disor, count);
    }


    private static int helper(long dividend , long divisor, int count){
        if(count == 0){
            return 0;
        }
        if(dividend < divisor) {
            divisor = divisor >> 1;
            dividend = dividend - divisor;
            count = count >> 1;
            return helper(dividend, divisor, count) + count;
        }
        return helper(dividend , divisor << 1, count << 1) ;
    }


    public static void main(String[] args) {

        System.out.println(DivideTwoIntegers.divide(16,3));

        String s1 = "34";
        String s2 = "3";

        System.out.println(s2.compareTo(s1));


        char[] row1 = {'a','b','c'};
        char[] row2 ={'x','y','z'};
        char[] row3 = {'1','2','3'};
        char[] row4 = {'k','l','m'};

        char[][] sampleArray = new char[][]{row1,row2,row3, row4};
        System.out.println("Row Size " +sampleArray.length);
        System.out.println("Column size " + sampleArray[0].length);

        int a = 0b01001;
        int b = 0b10000000;

        System.out.println(a^b);



    }
}
