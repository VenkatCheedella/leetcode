package com.leetcode.popularAlgos;

import java.util.Arrays;

public class FindDuplicate {
	
	public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }
	
}
