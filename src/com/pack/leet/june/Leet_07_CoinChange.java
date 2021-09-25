package com.pack.leet.june;

import java.util.Arrays;

/*
Coin Change 2

You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
 */
public class Leet_07_CoinChange {

	public static void main(String[] args) {
		Leet_07_CoinChange obj = new Leet_07_CoinChange();
		int amount = 5;
		int[] coins = {1, 2, 5};
		System.out.println(obj.change(amount, coins));
	}
	/*
	 make 2D array of size coins.length x amount+1 
	 */
	public int change(int amount, int[] coins) {
		Arrays.sort(coins);
		// Declaring a 2-D array
	      // for storing solutions to subproblems:
	    	int size = coins.length;
	    	int[][] dp = new int[size + 1][amount + 1];
	    	
	      // Initializing first column of array to 1
	      // because a sum of 0 can be made
	      // in one possible way: {0}
	    	for(int i = 0; i < size + 1; i++)
	    		dp[i][0] = 1;
	    	
	      // Applying the recursive solution:
	    	for(int i = 1; i < size + 1; i++)
	    		for(int j = 0; j < amount + 1; j++)
	    			if(coins[i - 1] > j)  // Cannot pick the highest coin:
	    				dp[i][j] = dp[i - 1][j];
	    			else  // Pick the highest coin:
	    				dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
	    	
	    	return dp[size][amount];
    }
}
