package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.List;

public class FactorCombination {

    public static List<List<Integer>> factorsOfInteger(int N){
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findFactors(2, 1, N, current, combinations);
        return combinations;
    }

    private static void findFactors(int start, int product, int N, List<Integer> current, List<List<Integer>> combinations){
        if(product > N) return ;
        if(product == N){
            combinations.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i< N; i++){
            if(N % i == 0) {
                current.add(i);
                findFactors(i, i * product, N, current, combinations);
                current.remove(current.size()-1);
            }

        }
    }


    public static void main(String[] args) {
        FactorCombination.factorsOfInteger(12).forEach(System.out::print);
    }
}
