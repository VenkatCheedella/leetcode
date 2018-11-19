package com.leetcode.popularAlgos;

public class ProductOfArray {
    public static int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length ==1 ){
            return nums;
        }
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;

        // result of multiplies all the previous indices are stored in the current index from left
        for(int i = 1; i< len; ++i){
            result[i] = result[i-1] * nums[i-1];
        }

        // result of multiples of succeeding indices are mutliplied to current result
        int right = 1;
        for(int i = len-1; i >= 0; i--){
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {0,0};
        int[] results = ProductOfArray.productExceptSelf(nums);
        System.out.println(results.toString());
    }
}
