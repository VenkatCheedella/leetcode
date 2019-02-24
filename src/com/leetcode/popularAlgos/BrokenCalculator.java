package com.leetcode.popularAlgos;

import java.util.HashMap;
import java.util.Map;

public class BrokenCalculator {
	private static Map<Integer, Integer> cache = new HashMap<>();
	private static int minCount = Integer.MAX_VALUE;

	public static int brokenCalc(int X, int Y) {
		findMinCount(X, Y, 0);
		return minCount;
	}

	private static void findMinCount(int X, int Y, int currCount) {
		if (X <= 0 || X > Y)
			return;
		else if (currCount > minCount)
			return;
		else if (X == Y) {
			minCount = (minCount > currCount) ? currCount : minCount;
			return;
		} else if (cache.containsKey(X)) {
			int lastCount = cache.get(X);
			if(lastCount > currCount) cache.put(X, currCount);
			else return;
			
		} else {
			cache.put(X, currCount);
			findMinCount(X - 1, Y, currCount+1);
			findMinCount(X * 2, Y, currCount+1);
		}
	}

	public static void main(String[] args) {
//		System.out.println(BrokenCalculator.brokenCalc(2, 3));
//		System.out.println(BrokenCalculator.brokenCalc(5, 8));
		System.out.println(BrokenCalculator.brokenCalc(3, 10));
	}
}
