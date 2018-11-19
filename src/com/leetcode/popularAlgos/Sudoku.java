package com.leetcode.popularAlgos;

import java.util.HashSet;

public class Sudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> validChars = new HashSet<>();
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    String row = "(" + i+")" +board[i][j];
                    if(validChars.contains(row)) return false;
                    validChars.add(row);
                    String column = board[i][j] + "(" + j + ")";
                    if(validChars.contains(column)) return false;
                    validChars.add(column);
                    String smallMatrixEntry = "(" + i/3 + ")" + board[i][j] + "(" + j/3 + ")";
                    if(validChars.contains(smallMatrixEntry)) return false;
                    validChars.add(smallMatrixEntry);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] charArray = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
                              {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
                              {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(Sudoku.isValidSudoku(charArray));
    }
}
