package com.leetcode.popularAlgos;

public class SingleNumber {
	
	public int singleNumber(int[] nums) {
		
		if(nums == null) {
			return -1;
		}
		if(nums.length == 0) {
			return -1;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		int uniqueNumber = 0;
		for(int i=0; i< nums.length; ++i) {
			uniqueNumber = uniqueNumber ^ nums[i];
		}
		return uniqueNumber;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,5,2,4,1,4,2};
		System.out.println(new SingleNumber().singleNumber(nums));
	}

}
