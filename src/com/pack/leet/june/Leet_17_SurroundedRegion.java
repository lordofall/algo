package com.pack.leet.june;

import java.util.Arrays;

/*
Surrounded Regions
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Input:
X X X X
X O O X
X X O X
X O X X

Output:
X X X X
X X X X
X X X X
X O X X
 */
public class Leet_17_SurroundedRegion {

	public static void main(String[] args) {
		Leet_17_SurroundedRegion obj = new Leet_17_SurroundedRegion();
		char[][] board= {{'X', 'X', 'X', 'X'}, 
						 {'X', 'O', 'O', 'X'},
						 {'X', 'X', 'O', 'X'},
						 {'X', 'O', 'X', 'X'}};
		obj.solve(board);
		System.out.println(Arrays.deepToString(board));

	}
	
	//DFS
	public void solve(char[][] board) {
	    if(board == null || board.length==0) 
	        return;
	 
	    int m = board.length;
	    int n = board[0].length;
	 
	    //merge O's on left & right boarder
	    for(int i=0;i<m;i++){
	        if(board[i][0] == 'O'){
	            merge(board, i, 0);
	        }
	 
	        if(board[i][n-1] == 'O'){
	            merge(board, i, n-1);
	        }
	    }
	 
	    //merge O's on top & bottom boarder
	    for(int j=0; j<n; j++){
	         if(board[0][j] == 'O'){
	            merge(board, 0, j);
	        }
	 
	        if(board[m-1][j] == 'O'){
	            merge(board, m-1, j);
	        }
	    }
	 
	    //process the board
	    for(int i=0;i<m;i++){
	        for(int j=0; j<n; j++){
	            if(board[i][j] == 'O'){
	                board[i][j] = 'X';
	            }else if(board[i][j] == '#'){
	                board[i][j] = 'O';
	            }
	        }
	    }
	}
	 
	public void merge(char[][] board, int i, int j){
	    board[i][j] = '#';
	 
	    int[] dx = {-1, 0, 1, 0};
	    int[] dy = {0, 1, 0, -1};
	 
	    for(int k=0; k<4; k++){
	        int x = i+dx[k];
	        int y = j+dy[k];
	 
	        if(x>=0 && x<board.length
	          && y>=0 && y<board[0].length
	          && board[x][y]=='O'){
	            merge(board, x, y);
	        }
	    }
	}

}
