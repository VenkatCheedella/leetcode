package com.leetcode.popularAlgos;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	Map<Character, Integer> romanIndices = new HashMap<>();
	
	public int romanToInt(String s) {
		int total = 0;
		for(int i=s.length() -1; i >=0 ; --i) {
			if(s.charAt(i) == 'I') {
				total += (total >= 5) ? -1 : 1;
			}
			if(s.charAt(i) == 'V') {
				total += (total >= 50) ? -5 : 5;
			}
			if(s.charAt(i) == 'X') {
				total += (total >= 50) ? -10 : 10;
			}
			if(s.charAt(i) == 'L') {
				total += (total >= 400) ? -50 : 50;
			}
			if(s.charAt(i) == 'C') {
				total += (total >= 500) ? -100 : 100;
			}
			if(s.charAt(i) == 'D') {
				total += 500;
			}
			if(s.charAt(i) == 'M') {
				total += 1000;
			}
		}
		return total;
	}
	
	
	public static void main(String[] args) {
		RomanToInteger romanToInteger = new RomanToInteger();
		System.out.println("Integer value of roman : " + romanToInteger.romanToInt("XL"));
	}
}
