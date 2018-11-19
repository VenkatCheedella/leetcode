package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> possiblePermutations = new ArrayList<>();
        helper(possiblePermutations, new ArrayList<Integer>(), nums);
        return possiblePermutations;
    }

    private void helper(List<List<Integer>> permutations, List<Integer> permutation, int[] nums){
        if(permutation.size() == nums.length){
            permutations.add(new ArrayList<>(permutation));
            return;
        }else{
            for(int i=0; i< nums.length; i++){
                if(permutation.contains(nums[i])) continue;
                permutation.add(nums[i]);
                helper(permutations, permutation, nums);
                permutation.remove(permutation.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        List<List<Integer>> permutationArray = p.permute(new int[]{1,2,3});
        permutationArray.forEach(System.out::println);
    }
}
