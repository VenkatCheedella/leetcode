package com.leetcode.popularAlgos;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		int majorityIndex = 0;
		int count = 1;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == nums[majorityIndex]) {
				++count;
				continue;
			}
			if (count == 0) {
				majorityIndex = i;
				count = 1;
			}
			--count;
		}
		return nums[majorityIndex];
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3, 3, 2, 2, 2, 3, 2, 2 };
		System.out.println(new MajorityElement().majorityElement(nums));
	}

}
