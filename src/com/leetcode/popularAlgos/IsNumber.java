package com.leetcode.popularAlgos;

public class IsNumber {

    public static boolean isStringNumber(String number){
        if(number == null || number.length() == 0) return false;
        char[] nums = number.toCharArray();
        for(char c: nums){
            if(c - '0' >= 0 && c - '0' <= 9) continue;
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(IsNumber.isStringNumber("12as"));
    }

}
