package com.leetcode.popularAlgos;

public class Rook {
	
	private int rookX = -1;
    private int rookY = -1;
    
    public int numRookCaptures(char[][] board) {
        getRookCoordinates(board);
        return checkIfBlackPawnExist(rookX+1, rookY, board, 1,0) + checkIfBlackPawnExist(rookX-1, rookY, board, -1, 0)
            + checkIfBlackPawnExist(rookX, rookY+1, board, 0, 1) + checkIfBlackPawnExist(rookX, rookY-1, board, 0, -1);
        
    }
    
    private void getRookCoordinates(char[][] board){
        for(int i=0; i< board.length; i++){
            for(int j= 0; j < board[0].length; j++){
                if(board[i][j] == 'R'){
                    rookX = i;
                    rookY = j;
                    break;
                }
            }
        }
    }
    
    private int checkIfBlackPawnExist(int i, int j, char[][] board, int xDir, int yDir){
        if(i < 0 || i >= board.length || j <0 || j >= board[0].length || board[i][j] == 'B') return 0;
        if(board[i][j] == 'p') return 1;
        else{
            i = (xDir == 0) ? i : (xDir < 0 ) ? i-1 : i+1;
            j = (yDir == 0) ? j : (yDir < 0 ) ? j-1 : j+1; 
            return checkIfBlackPawnExist(i, j, board, xDir, yDir);
        }
    }
    
    public static void main(String[] args) {
    	char[][] board = new char[][] {
    			{'.','.','.','.','.','.','.','.'},
    			{'.','.','.','.','.','.','.','.'},
    			{'.','.','.','.','p','.','.','.'},
    			{'.','.','.','.','R','.','.','.'},
    			{'.','.','.','.','.','.','.','.'},
    			{'.','.','.','.','.','.','.','.'},
    			{'.','.','.','.','.','.','.','.'},
    			{'.','.','.','.','.','.','.','.'},
    	};
    	
    	Rook rooky =new Rook();
    	System.out.println(rooky.numRookCaptures(board));
    }
	
}
