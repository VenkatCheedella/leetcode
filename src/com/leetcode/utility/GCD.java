package com.leetcode.utility;

public class GCD {

    public int GCD(int divident, int divisor){
        return (divisor == 0) ? divident : GCD(divisor, divident%divisor);
    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.GCD(3,4));
    }
}
