package com.leetcode.popularAlgos;

public class MedianOfTwoArrays {
	
	private static double calMid(int midA, int midB, int totalLen){
        if(totalLen %2 == 0){
            return (midA+midB)/2;
        }
        else{
            return midB;
        }
    }
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        
         if(nums1 == null && nums2 == null){
             return 0;
         }     
         int nums[] = null;
            
         if(nums1 == null || nums2 == null){
            if(nums1 == null){
             nums = nums2;
            }else{
             nums = nums1;
            }   
            int mid = nums.length/2;
            if(nums.length %2 == 0){
                return (nums[mid-1] + nums[mid])/2;
            }else{
                return nums[mid];
            }
        }
        
        if(nums1.length < nums2.length) return helper(nums1, nums2);
        else return helper(nums2, nums1); 
    }
    
    
    public static double helper(int[] nums1, int[] nums2) {
        int midA = nums1.length/2-1;
        int midB = nums2.length/2-1;
        int midANext = midA+1;
        int midBNext = midB+1;
        int totalLen = nums1.length + nums2.length;
        
        if(nums1.length == 1 && nums2.length == 1){
            return (nums1[0] + nums2[0])/2;
        }
        
        if(nums1.length == 1){
            int mid = nums2.length/2;
            if(nums2.length %2 == 0){
                 if(nums2[mid-1] <= nums1[0] && nums2[mid] >= nums1[0]){
                    return nums1[0];
                }else{
                    return (nums2[mid] + nums2[mid-1])/2;
              }
            }else{
                if(nums2[mid-1] <= nums1[0] && nums2[mid] >= nums1[0]){
                    return (nums1[0] + nums2[mid])/2;
                }else if(nums2[mid-1] > nums1[0]){
                    return (nums2[mid-1] + nums2[mid])/2;
                }else{
                    return nums2[mid] + nums2[mid+1]/2;
                }
            }
        }
        
        while(midA > 0  && midANext < nums1.length){
            if(nums1[midA] <= nums2[midBNext] && nums2[midB] <= nums1[midANext]){
                int x = (nums1[midA] < nums2[midB]) ? nums2[midB] : nums1[midA];
                int y = (nums1[midANext] < nums2[midBNext]) ? nums1[midANext] : nums2[midBNext];
                return calMid(x, y, totalLen);
            }
            else if (nums1[midA] > nums2[midBNext]){
                midA = (0+ midA)/2;
                midANext = midA+1;
            }else{
                midA = (midA + nums1.length)/2-1;
                midANext = midA+1;
            }
        }
        if(midA < 0){
            midA = 0;
            midANext = 1;
        }
        if(midANext == nums1.length){
            midANext = nums1.length-1;
            midA = midANext-1;
        }
        while(midB > 0 && midBNext < nums2.length){
                if(nums1[midA] <= nums2[midBNext] && nums2[midB] <= nums1[midANext]){
                     int x = (nums1[midA] < nums2[midB]) ? nums2[midB] : nums1[midA];
                     int y = (nums1[midANext] < nums2[midBNext]) ? nums1[midANext] : nums2[midBNext];
                    return calMid(x, y, totalLen);
                }
            else if(midANext == nums1.length-1 && midB == 0){
                return calMid(nums1[midANext], nums2[midB], totalLen);
            }
            else if(midA == 0 && midBNext == nums1.length-1){
                return calMid(nums1[midA],nums2[midBNext] , totalLen);
            }
            else if(nums2[midB] > nums1[midANext]){
                midB = (0 + midB)/2;
                midBNext = midB+1;
            }else{
                midB = (midB + nums2.length)/2 -1;
                midBNext = midB+1; 
            }
        }
        throw new IllegalArgumentException();
    }
	
	public static void main(String[] args) {
		int nums1[] = {1,2};
		int nums2[] = {3,4};
		int a =2;
		int b =3;
		System.out.println(((double)a + (double)b ) /2);
		//System.out.println(MedianOfTwoArrays.findMedianSortedArrays(nums1, nums2));
		String sample = "start";
		System.out.println(sample.startsWith("start"));
		
	}

}
