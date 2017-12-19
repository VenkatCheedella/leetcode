package com.leetcode.popularAlgos;

public class MoveZeros {
	
	
	private int nextZeroIndex(int[] nums, int currentIndex) {
		while(nums[currentIndex] != 0) {
			if(currentIndex == nums.length-1) {
				return -1;
			}
			++currentIndex;
		}
		return currentIndex;
	}
	
	public void moveZeros(int[] nums) {
		if(nums == null) {
			return ;
		}
		if(nums.length == 1) {
			return ;
		}
		int zero_iter = nextZeroIndex(nums, 0);
		if(zero_iter == -1) {
			return;
		}
		int iter = zero_iter+1;
		while(iter < nums.length) {
			if(nums[iter] != 0) {
				// swap  numbers 
				nums[zero_iter] = nums[iter];
				nums[iter] = 0;
				zero_iter = nextZeroIndex(nums, zero_iter);
				++iter;
			}
			else {
				++iter;
			}
		}
		for(int i=0; i<nums.length; ++i) {
			System.out.print(nums[i] + "\t");
		}
	}
	
	
	private int findNextZero(int[] nums, int currentIndex) {
		if(currentIndex >= nums.length) return ++currentIndex;
		if(nums[currentIndex] == 0) return currentIndex;
		return findNextZero(nums, ++currentIndex);
	}
	
	private int findNextNonZero(int[] nums, int currentIndex) {
		if(currentIndex >= nums.length) return ++currentIndex;
		if(nums[currentIndex] != 0 ) return currentIndex;
		return findNextNonZero(nums, ++currentIndex);
	}
	
	
	public void moveZerosIter(int[] nums) {
		if(nums == null) return ;
		if(nums.length == 1) return ;
		int zeroIter = findNextZero(nums, 0);
		if(zeroIter >= nums.length-1) return;
		int nonZeroIter = findNextNonZero(nums, zeroIter);
		if(nonZeroIter >= nums.length) return ;
		while(nonZeroIter < nums.length && zeroIter < nums.length) {
			nums[zeroIter] = nums[nonZeroIter];
			nums[nonZeroIter] = 0;
			zeroIter = findNextZero(nums, ++zeroIter);
			nonZeroIter = findNextNonZero(nums, ++nonZeroIter);
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {2,3,4,0,5,6,0,8,6};
		//int[] nums1 = new int[] {2,3,4,5,6,8,6};
		new MoveZeros().moveZerosIter(nums1);
		for(int i=0; i< nums1.length; ++i) {
			System.out.println(nums1[i]);
		}
	}
}
