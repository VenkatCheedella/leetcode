package com.leetcode.popularAlgos;

public class MovieRating {

    // 1, -5, -4, -3, -4, -5, 8
    //  -12,-8,-7,-4,-5
    // start =  3, limit = 1, nums -> 1,2,3,4,5 dp -> 0,1,2,3,4
    public static int findCount(int[] dp, int[] nums, int start, int limit){
        if(start < limit){
            return Math.max(dp[0],dp[0+1]);
        }
        else{
            dp[start-limit] = Math.max(nums[start]+dp[start-limit+1], nums[start]+dp[start-limit+2]);
            return findCount(dp,nums,--start, limit);
        }
    }

    private static int negativeNumsCount(int i, int[] nums){
        int count = 0;
        while(i < nums.length && nums[i++] < 0) ++count;
        return count;
    }

    public static int findMaxRatings(int[] movieRating){
        int rating = 0;
        for(int i = 0; i< movieRating.length;){
            if(movieRating[i] >= 0) rating+= movieRating[i++];
            else {
                int negNumCount = negativeNumsCount(i, movieRating);
                if(negNumCount == 1){
                    i++;
                }
                else if(negNumCount ==  2){
                    int minRating = Math.max(movieRating[i], movieRating[i+1]);
                    rating+=minRating;
                    i = i+2;
                }else{
                    int[] dp = new int[negNumCount];
                    dp[negNumCount-1] = movieRating[i+negNumCount-1];
                    dp[negNumCount-2] = Math.max(movieRating[i+negNumCount-1], movieRating[i+negNumCount-2]);
                    int minRating = findCount(dp, movieRating, i+negNumCount-3, i);
                    rating+=minRating;
                    i = i+negNumCount-1;
                }
            }

        }
        return rating;
    }


    public static void main(String[] args) {
        int[] newArray = new int[]{1,-5,-4,-3,-4,-5,8};
        int[] input2 = new int[]{50,50,-4,-16,-10};
        int[] dp = new int[newArray.length];
        //System.out.println(MovieRating.findCount(dp, newArray, 2, 0));
        System.out.println(MovieRating.findMaxRatings(input2));
    }
}
