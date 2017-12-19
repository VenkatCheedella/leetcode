package com.leetcode.popularAlgos;
import java.util.Arrays;

public class MediaOfTwoArrays {
	
	
	private double medianOfAnArray(int[] nums, int len) {
		int middleIndex = len/2 ;
		
		if(len == 0) {
			return -1;
		}
		if(len%2 == 0) {
			return (nums[middleIndex/2] + nums[middleIndex/2-1])/2;
		}else {
			return nums[middleIndex];
		}
	}
	
	
	private double arraySizeOne(int[] nums1, int nums1Len, int[] nums2, int nums2Len) {
		int middleIndex = nums2Len/2;
		
		//if len of nums2 < 3
		if(nums1[0] < nums2[0]) {
			return nums2[0];
		}
		
		if(nums1[0] < nums2[1]) {
			return nums1[0];
		}
		
		if(nums1[0] >= nums2[1]) {
			return nums2[1];
		}
		
		if(nums2Len % 2 == 0) {
			int leftNum = nums2[middleIndex-1];
			int rightNum = nums2[middleIndex];
			if(leftNum >= nums1[0]) {
				return leftNum;
			}
			else if(rightNum >= nums1[0]){
				return nums1[0];
			}
			else {
				return rightNum;
			}
		}
		else {
			int left = nums2[middleIndex-1];
			int middle = nums2[middleIndex];
			int right = nums2[middleIndex+1];
			if(nums1[0] < left) {
				return (left + middle)/2;
			}
			else if (nums1[0] < middle || nums1[0] < right) {
				return (nums1[0] + middle)/2;
			}
			else {
				return (middle + right)/2;
			}
		}
	}
	
	private double arraySizeTwo(int[] nums1, int nums1Len, int[] nums2, int nums2Len) {
		int medianIndex = nums2Len/2;
		if(nums2Len %2 == 0) {
			int leftMedian = nums2[medianIndex/2-1];
			int rightMedian = nums2[medianIndex/2];
			int left = nums2[medianIndex/2 -2];
			int right = nums2[medianIndex/2+1];
			
			left = (nums1[0]> left) ? nums1[0] : left;
			right = (nums1[1] < right) ? nums1[1] : right;
			
			int[] tempArray = new int[4];
			tempArray[0] = leftMedian;
			tempArray[1] = rightMedian;
			tempArray[2] = left;
			tempArray[3] = right;
			
			Arrays.sort(tempArray);
			return (tempArray[1] +tempArray[2])/2;
		}
		else {
			int median = nums2[medianIndex/2];
			int left = nums2[medianIndex/2-1];
			int right = nums2[medianIndex/2+1];
			
			left = (nums1[0] > left) ? nums1[0] : left;
			right = (nums1[1] < right) ? nums1[1] : right;
			
			int[] tempNums = new int[3];
			tempNums[0] = median;
			tempNums[1] = left;
			tempNums[2] = right;
			
			Arrays.sort(tempNums);
			return tempNums[1];
		}
	}
	
	private double medianOfTwoSortedArrays(int[] nums1, int nums1Len, int[] nums2,  int nums2Len) {
		double median = 0.0;
		
		if(nums1Len == 0 && nums2Len == 0) {
			return -1;
		}
		if(nums1Len == 0) {
			return medianOfAnArray(nums2, nums2Len);
		}
		if(nums2Len == 0) {
			return medianOfAnArray(nums1, nums1Len);
		}
		if(nums1Len == 1 && nums2Len ==1) {
			return (nums1[0] + nums2[0])/2;
		}
		if(nums1Len ==1) {
			return arraySizeOne(nums1, nums1Len, nums2, nums2Len);
		}
		if(nums2Len == 1) {
			return arraySizeOne(nums2, nums2Len, nums1, nums1Len);
		}
		if(nums1Len == 2 && nums2Len ==2) {
			int median1 = (nums1[0] + nums1[1])/2;
			int median2 = (nums2[0] + nums2[1])/2;
			return (median1 + median2)/2;
		}
		if(nums1Len ==2) {
			return arraySizeTwo(nums1, nums1Len, nums2, nums2Len);
		}
		if(nums2Len ==2) {
			return arraySizeTwo(nums2, nums2Len, nums1, nums1Len);
		}
		
		double nums1Median = medianOfAnArray(nums1, nums1Len);
		double nums2Median = medianOfAnArray(nums2, nums2Len);
		
		if(nums1Median == nums2Median) {
			return nums1Median;
		}
		
		if(nums1Median > nums2Median) {
			nums1 = returnArrayInRangeOfElements(nums1, 0, nums1Len/2+1);
			int cuttingLen = nums1Len/2-1;
			nums2 = returnArrayInRangeOfElements(nums2, nums2Len/2, nums2Len);
			
		}
		return median;
	}
	
	private int[] returnArrayInRangeOfElements(int[] nums, int startIndex, int endIndex) {
		int[] newArray = new int[endIndex-startIndex];
		for(int i=0; i< newArray.length; ++i) {
			newArray[i] = nums[startIndex++];
		}
		return newArray;
	}
	
	
	public double medianOfTwoSortedArrays(int[] nums1, int[] nums2) {
		return medianOfTwoSortedArrays(nums1, nums1.length, nums2, nums2.length);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
