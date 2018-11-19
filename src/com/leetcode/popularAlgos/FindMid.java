package com.leetcode.popularAlgos;

public class FindMid {
    private static int getStartIdx(int[] rArray){
        int left=0;
        int right = rArray.length-1;
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(rArray[mid] > rArray[right]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return mid;
    }

    private static int findNum(int[] rArray, int num, int start, int end){
        while(start <= end){
            int mid = (start + end)/2;
            if (rArray[mid] == num) return mid;
            else if(rArray[mid] < num){
                start = mid+1;
            }else{
                end = mid -1;
            }

        }
        return -1;
    }

    public static int getIdx(int[] rArray, int num){

        if(rArray== null || rArray.length == 0) return -1;

        int smallestNumIdx = getStartIdx(rArray);
        System.out.println(smallestNumIdx);
        if(num > rArray[rArray.length-1]){
            return findNum(rArray, num, 0, smallestNumIdx -1);
        }
        else{
            return findNum(rArray, num , smallestNumIdx, rArray.length-1);
        }

    }

    public static void main(String args[] ) throws Exception {
        int[] rArray = new int[]{4, 5, 6, 7,  8, 9,  0, 1, 2, 3};
        System.out.println(FindMid.getIdx(rArray, 9));

    }
}
