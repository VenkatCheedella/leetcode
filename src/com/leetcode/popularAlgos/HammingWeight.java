package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.List;


class InvalidInput extends Exception {
	public InvalidInput(String msg) {
		super(msg);
	}
}


public class HammingWeight {
	
	public int hammingWeight(int n) {
        int count =0;
        while(n != 0){
            if ((n & 1) > 0) ++count;
            n = n >>> 1;
        }
        return count;
    }
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(0,1);
		numbers.add(0,2);
		
		System.out.println(numbers.size());
	}
}
