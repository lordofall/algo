package com.pack.leet.may;

import java.util.Arrays;

/*
We write the integers of A and B (in the order they are given) on two separate horizontal lines.
Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
Return the maximum number of connecting lines we can draw in this way. 

Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3
*/
public class Leet_26_LCS {

	int[][] dp = null;
	public static void main(String[] args) {
		Leet_26_LCS obj = new Leet_26_LCS();
		int[] A = new int[] {2,5,1,2,5};
		int[] B = new int[] {10,5,2,1,5,2};
		
		System.out.println(obj.maxUncrossedLines(A, B));

	}

	public int maxUncrossedLines(int[] A, int[] B) {
		dp = new int[A.length][B.length];
		for(int[] x: dp) {
			Arrays.fill(x, -1);
		}
		return maxUncrossedLines(A, B, 0, 0);
	}

	private int maxUncrossedLines(int[] a, int[] b, int i, int j) {
		if(i == a.length || j == b.length) return 0;
		
		if(dp[i][j] != -1) return dp[i][j];
		
		int result = 0;
		if(a[i] == b[j]) result = 1 + maxUncrossedLines(a, b, i+1, j+1);
		else result = Math.max(maxUncrossedLines(a, b, i+1, j), maxUncrossedLines(a, b, i, j+1));
		dp[i][j] = result;
		return result;
	}
}
