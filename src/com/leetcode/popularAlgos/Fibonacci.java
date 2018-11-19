package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    private static List<Integer> fibonacciSeries(int n, List<Integer> fib){
        if(n == 0 ) return fib;
        int size = fib.size();
	    int next = fib.get(size-1) + fib.get(size-2);
        fib.add(next);
        return fibonacciSeries(--n, fib);
    }

    public static List<Integer> fbSeries(int n){
        if(n <= 0) return null;
        List<Integer> nums = new ArrayList<>();
        nums.add(0);
        if(n == 1) return nums;
        nums.add(1);
        if(n == 2) return nums;
        return fibonacciSeries(n-2, nums);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.fbSeries(5));
    }
}
