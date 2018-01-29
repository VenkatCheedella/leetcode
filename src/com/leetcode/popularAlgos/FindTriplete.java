package com.leetcode.popularAlgos;

import java.util.Arrays;

public class FindTriplete {
	
	public static long triplete(long t, int[] d) {
		if(d == null || d.length < 3) {
			return 0;
		}
		Arrays.sort(d);
		long countOftripletes = 0;
		for(int i =0 ; i< d.length-2; ++i) {
			int secondElement = i+1;
			int thirdElement = d.length -1;
			while(thirdElement > secondElement) {
				if(d[i] + d[secondElement] + d[thirdElement] <= t) {
					countOftripletes += (thirdElement - secondElement);
					++secondElement;
				}
				else {
					--thirdElement;
				}
			}
		}
		return countOftripletes;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,4,5,3,10, 14, 15};
		System.out.println(triplete(15, nums));
	}
}
