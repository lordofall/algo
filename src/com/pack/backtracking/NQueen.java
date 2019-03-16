package com.pack.backtracking;

import java.util.Arrays;

public class NQueen {

	private static final int N = 4;
	
	public static void main(String[] args) {
		int[][] board = new int[N][N];
		solveNQ(board);
		printBoard(board);
	}
	
	/**
	 * 
	 * check if queen is safe at position board[row][col]
	 * @param board
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean isSafe(int[][] board, int row, int col) {
		// if in same col
		for(int i = 0; i < row; i++) {
			if(board[i][col] == 1) return false;
		}
		
		// if in left diagonal
		for(int i = 1; (row-i) >= 0 && (col-i) >= 0 ;i++) {
			if(board[row-i][col-i] == 1) return false;
		}
		
		// if in right diagonal
		for (int i = 1; (row - i >= 0) && (col + i) < N; i++) {
			if(board[row-i][col+i] == 1) return false;
		}
		
		return true;
	}
	
	private static void solveNQ(int[][] board) {
		
		if(solveNQUtil(board, 0) == false)
			System.out.println("no result exist");
		
	}
	
	/**
	 * place ith queen on the board
	 * @param board
	 * @param i
	 * @return
	 */
	private static boolean solveNQUtil(int[][] board, int i) {
		
		System.out.println("finding place for queen "+i);
		if(i == N) return true;
		
		for(int j = 0; j < N; j++) {
			if(isSafe(board, i, j)) {
				board[i][j] = 1;
				if(solveNQUtil(board, i+1) == true) {
					return true;
				}
				board[i][j] = 0; // backtrack
			}
		}
		return false;
	}

	private static void printBoard(int[][] board) {
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		
	}
}
