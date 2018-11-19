package com.leetcode.popularAlgos;

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0, j=0, iter=0;
        int[] result = new int[m+n];
        while(i<m && j <n){
            if(nums1[i] < nums2[j]){
                result[iter++] = nums1[i++];
            }else{
                result[iter++] = nums2[j++];
            }
        }
        while(i < m){
            result[iter++] = nums1[i++];
        }
        while(j<n){
            result[iter++] = nums2[j++];
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        MergeSortedArrays.merge(null, 3, null, 3);
    }
}
