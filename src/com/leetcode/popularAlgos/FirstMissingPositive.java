package com.leetcode.popularAlgos;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while( i < nums.length){
            if(nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length) i++;
            else if(nums[nums[i] -1] != nums[i]) swap(nums, i, nums[i]-1);
            else i++;
        }
        i=0;
        while(i < nums.length && nums[i] == i+1) i++;
        return ++i;

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] nums = {1,2,0};
        System.out.println(fmp.firstMissingPositive(nums));
    }
}
