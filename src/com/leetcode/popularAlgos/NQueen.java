package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> pos = new ArrayList<>();
        List<List<Integer>> curr = new ArrayList<>();
        int[][] board = new int[n][n];
        helper(0,0,pos,board, curr);
        return pos;
    }

    private void helper(int startR, int startC, List<List<Integer>> pos, int[][] board, List<List<Integer>> curr) {
        if(startC >= board[0].length){
            return;
        }
        if(startR == board.length){
            System.out.println(curr);
            return;
        }
        for(int i=startR; i< board.length; i++){
            boolean rowFlag = false;
            for(int j=startC; j < board[0].length; j++){
                if(isValid(board, i,j)){
                    rowFlag = true;
                    board[i][j] = 1;
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    curr.add(point);
                    helper(++startR, 0, curr, board, curr);
                    curr.remove(curr.size()-1);
                    board[i][j] = 0;
                    --startR;
                    rowFlag = false;
                }
            }
            if(!rowFlag) return;
        }
    }

    private boolean isValid(int[][] board, int i, int j){
        if(i < 1 ) return true;
        for(int k = 0; k < i; k++){
            if(board[k][j] == 1) return false;
        }
        for(int k = Integer.max(0,i-1), l = Integer.max(0,j-1); k >= 0 && l >=0; k--, l--){
            if(board[k][l] == 1) return false;
        }
        for(int k = Integer.max(0,i-1), l = Integer.min(board[0].length-1, j+1); k >= 0 && l < board[0].length-1 ; k--, l++){
            if(board[k][l] == 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen q = new NQueen();
        System.out.println(q.solveNQueens(4));
    }

}
