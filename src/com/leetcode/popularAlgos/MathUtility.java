package com.leetcode.popularAlgos;

public class MathUtility<T extends Number> {

    public boolean compare (T a, T b){
        return a.equals(b);
    }


    public static void main(String[] args) {

        MathUtility<Integer> utility = new MathUtility<>();
        System.out.println(utility.compare(3,4));
        MathUtility<Double> floatUtility = new MathUtility<>();
        System.out.println(floatUtility.compare(3.4,3.4));
    }
}
