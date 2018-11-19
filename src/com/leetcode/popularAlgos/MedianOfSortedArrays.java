package com.leetcode.popularAlgos;

public class MedianOfSortedArrays {

    public double mediaOfTwoSortedArrrays(int[] nums1, int[] nums2){

        if(nums1.length > nums2.length){
            return mediaOfTwoSortedArrrays(nums2, nums1);
        }

        int x =0;
        int y = nums1.length;
        int partitionX, partitionY, xLeftMax, xRightMin, yLeftMax, yRightMin;
        while(x <= y){
            partitionX = (x+y)/2;
            partitionY = (nums1.length+nums2.length+1)/2 - partitionX;
            xLeftMax = (partitionX == 0) ? Integer.MIN_VALUE : (nums1[partitionX-1]);
            xRightMin = (partitionX == nums1.length) ? Integer.MAX_VALUE : nums1[partitionX];
            yLeftMax = (partitionY == 0) ? Integer.MIN_VALUE : (nums2[partitionY-1]);
            yRightMin = (partitionY == nums2.length) ? Integer.MAX_VALUE : (nums2[partitionY]);

            if(xLeftMax <= yRightMin && yLeftMax <= xRightMin){
                if((nums1.length + nums2.length) % 2 == 0) {
                    return ((double)(Math.max(xLeftMax, yLeftMax) +Math.min(xRightMin, yRightMin))/2);
                }
                else{
                    return (double)Math.max(xLeftMax, yLeftMax);
                }
            }

            else if (xLeftMax > yRightMin){
                y = partitionX-1;
            }

            else{
                x = partitionX+1;
            }
        }

        throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        MedianOfSortedArrays msa = new MedianOfSortedArrays();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(msa.mediaOfTwoSortedArrrays(nums1, nums2));
    }
}
