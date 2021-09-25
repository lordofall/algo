package com.pack.educative.dp;

/**
 * Given a set of positive numbers, determine 
 * if there exists a subset 
 * whose sum is equal to a given number ‘S’.
 * 
 * Input: {1, 2, 3, 7}, S=6
 * Output: True
 * The given set has a subset whose sum is '6': {1, 2, 3}
 * @author LordOfAll
 *
 */
public class SubsetSum {

	public static void main(String[] args) {
		SubsetSum obj = new SubsetSum();
		int[] arr = {1, 2, 2, 7};
		int S = 6;
		System.out.println(obj.subsetSum(arr, S));
	}

	// Bottom-up Dynamic Programming
	private boolean subsetSum(int[] arr, int capacity) {
		int rows = arr.length;
		int cols = capacity + 1;
		boolean[][] dp = new boolean[rows][cols];
		
		// fill first column with true, can get a sum of '0'
		// without selecting anything
		for(int i = 0; i< rows; i++) {
			dp[i][0] = true;
		}
		
		// fill first row
		for(int c = 1; c < cols; c++) { // start from 1 as dp[0][0] is already filled
			dp[0][c] = (arr[0] == c);
		}
		
		for(int i = 1; i < rows; i++) {
			for (int s = 1; s < cols; s++) {
				// exclude arr[i]
				if(dp[i-1][s]) {
					dp[i][s] = dp[i-1][s];
				}
				// incluse arr[i]
				else if(s-arr[i] >= 0) {
					dp[i][s] = dp[i-1][s-arr[i]];
				}
				
			}
		}
		return dp[rows-1][cols-1];
	}
	
	

}
