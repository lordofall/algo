package com.pack.contest;
/*
 * 5454. Count Submatrices With All Ones
Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.

Input: mat = [[1,0,1],
              [1,1,0],
              [1,1,0]]
Output: 13
Explanation:
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2. 
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.

Input: mat = [[1,1,1,1,1,1]]
Output: 21

Input: mat = [[1,0,1],[0,1,0],[1,0,1]]
Output: 5
 */
public class Leet_196_03_TP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numSubmat(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		int count = 0;
		
		int[][] dp = new int[rows+1][cols+1];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				// check for i = 0 and j = 0;; special case
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				if(mat[i][j] == 1) 
					dp[i][j] +=1;
				if(mat[i-1][j] == 1) dp[i][j] +=1;
				if(mat[i][j-1] == 1) dp[i][j] +=1;
			}
		}
		
		// calculate the sum of the array
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				count += mat[i][j];
			}
		}
		
        return count;
    }

}
