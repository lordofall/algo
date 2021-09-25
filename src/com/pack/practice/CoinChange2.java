package com.pack.practice;

import java.util.Arrays;

/**
 * 518. Coin Change 2 You are given coins of different denominations and a total
 * amount of money. Write a function to compute the number of combinations that
 * make up that amount. You may assume that you have infinite number of each
 * kind of coin.
 * 
 * @author LordOfAll
 *
 */
public class CoinChange2 {

	public static void main(String[] args) {
		// int amount = 5; int[] coins = {1, 2, 5}; // outcome 4
		// int amount = 3; int[] coins = {2}; // outcome 4
		int amount = 0;
		int[] coins = {}; // outcome 4
		CoinChange2 obj = new CoinChange2();
		int result = obj.change(amount, coins);
		System.out.println(result);
	}

	public int change(int amount, int[] coins) {
		Arrays.sort(coins);
		int noOfCoins = coins.length;
		int[][] dp = new int[noOfCoins + 1][amount + 1]; 

		// Initializing first column of array to 1 as we can get 0 amount using no coin.
		for (int i = 0; i <= noOfCoins; i++)
			dp[i][0] = 1;

		
		for (int i = 1; i <= noOfCoins; i++)
			for (int j = 0; j <= amount; j++)
				if (coins[i - 1] > j) // coin value is greater than amount, then just copy from above row.
					dp[i][j] = dp[i - 1][j];
				else // find ways by include coin + find ways by excluding coin
					dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];

		return dp[noOfCoins][amount];
	}

}
