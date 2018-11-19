package com.leetcode.popularAlgos;

public class UniquePaths {

    public static int uniquePaths(int cols, int rows) {
        int[] cur = new int[cols];

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++)
                cur[j] = cur[j-1] + cur[j] + 1;
        }
        return cur[cols-1] + 1;
    }

    public static void main(String[] args) {
        System.out.println(UniquePaths.uniquePaths(4,3));
    }
}
