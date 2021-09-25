package com.pack.leet.june;
/* ACCEPTED
Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Input: m = 7, n = 3
Output: 28

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.

 */
public class Leet_30_UniquePath {

	public static void main(String[] args) {
		Leet_30_UniquePath obj = new Leet_30_UniquePath();
		int m = 7; int n = 3;
		System.out.println(obj.uniquePaths(m, n));

	}
	
	 public int uniquePaths(int cols, int rows) {
		 int[][] dp = new int[rows][cols];

		 for(int i = 0; i < rows; i++)
			 dp[i][0] = 1;
		 
		 for(int j = 0; j < cols; j++)
			 dp[0][j] = 1;
		 
		 for(int i = 1; i < rows; i++ ) {
			 for(int j = 1; j < cols; j++) {
				 dp[i][j] = dp[i-1][j]  + dp[i][j-1];
			 }
		 }
		 return dp[rows-1][cols-1];
	 }

}
