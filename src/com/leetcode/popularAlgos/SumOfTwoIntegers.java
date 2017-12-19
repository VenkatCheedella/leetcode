package com.leetcode.popularAlgos;

public class SumOfTwoIntegers {
	
	public int getSum(int a, int b) {
		return (b == 0) ? a : getSum(a^b, (a&b)<<1); 
	}
	
	public static void main(String[] args) {
		System.out.println(new SumOfTwoIntegers().getSum(5, 3));
	}
	
}
