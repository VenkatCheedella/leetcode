package com.leetcode.popularAlgos;
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public List<String> fizzBuzz(int n){
		
		if(n < 1) {
			return null;
		}
		
		List<String> numbers = new ArrayList<>(n);
		for(int i =1 ; i < n+1 ; ++i) {
			if(i % 15 == 0) {
				numbers.add("FizzBuzz");
				continue;
			}
			if(i % 3 == 0) {
				numbers.add("Fizz");
				continue;
			}
			if(i % 5 == 0) {
				numbers.add("Buzz");
				continue;
			}
			numbers.add(Integer.toString(i));
		}
		return numbers;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new FizzBuzz().fizzBuzz(10));
	}
}
