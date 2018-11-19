package com.leetcode.popularAlgos;

public class SetColors {
    public static void sortColors(int[] A) {
        int j = 0, k = A.length-1;
        for (int i=0; i <= k; i++) {
            if (A[i] == 0)
                swap(A, i, j++);
            else if (A[i] == 2)
                swap(A,i--,k--);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SetColors.sortColors(new int[]{2,0,2,1,1,0});
        Thread t = new Thread();
    }
}
