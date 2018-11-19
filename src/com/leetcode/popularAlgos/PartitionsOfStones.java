package com.leetcode.popularAlgos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionsOfStones {

    public static int getHighestFrequency(int[] nums){

        if(nums == null || nums.length == 0) return -1;

        int[] jamie = nums;
        int[] ned = new int[nums.length];
        int i =0;
        for(int num : nums){
            ned[i++] = num;
        }
        Arrays.sort(ned);
        int[] geoff = new int[nums.length];

        for(i=0; i< geoff.length; i++){
            geoff[i] = jamie[i] + ned[i];
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        int maxFrequencyCount = Integer.MIN_VALUE;
        int maxFrequencyNum = Integer.MIN_VALUE;
        for(int j : geoff){
            frequency.put(j, frequency.getOrDefault(j,0)+1);
            int currCount = Integer.max(maxFrequencyCount, frequency.getOrDefault(j,0));
            if(maxFrequencyCount < currCount) {
                maxFrequencyNum = j;
                maxFrequencyCount = currCount;
            }
        }

        for(int k = geoff.length-1; k >=0; k--){
            if(maxFrequencyNum == geoff[k]) return k;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,5,9,19,2,2};
        int[] nums2 = {10,10,7,7,7,2,7,2};
        System.out.println(PartitionsOfStones.getHighestFrequency(nums2));
    }
}
