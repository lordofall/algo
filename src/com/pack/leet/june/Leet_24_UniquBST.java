package com.pack.leet.june;
/*
Unique Binary Search Trees 
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:
*/
public class Leet_24_UniquBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		return totalBST(n, dp);
	}

	private int totalBST(int n, int[] dp) {
		if (n == 0 || n == 1) // if there is no need, if have one way(ie empty), if we have 1 node, we have
								// one way
			return 1;
		if (dp[n] > 0)
			return dp[n];
		int count = 0;
		for (int i = 1; i <= n; i++)
			count += totalBST(i - 1, dp) * totalBST(n - i, dp);

		dp[n] = count;
		return dp[n];
	}
}
