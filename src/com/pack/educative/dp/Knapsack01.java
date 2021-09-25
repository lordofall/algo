package com.pack.educative.dp;

/**
 * Given two integer arrays to represent weights and profits of ‘N’ items, 
 * we need to find a subset of these items which will give us maximum profit 
 * such that their cumulative weight is not more than a given number ‘C’. 
 * Each item can only be selected once, 
 * which means either we put an item in the knapsack or we skip it.
 * 
 * @author LordOfAll
 *
 */
public class Knapsack01 {

	public static void main(String[] args) {
		int[] weights = { 2, 3, 1, 4 };
		int[] profits = { 4, 5, 3, 7 };
		int capacity = 5;
		Knapsack01 obj = new Knapsack01();
//		System.out.println(obj.solveKnapsack(weights, profits, capacity, 0)); // with bruth force recursion
		System.out.println(obj.solveKnapsack(weights, profits, capacity)); // top down, memoization

	}
	/*
	 * time complexity is O(2^n) , exponential
	 */
	private int knapsackRecursive(int[] weights, int[] profits, int capacity, int currentIndex) {
		// base condition, currentIndex falls out of array or capacity is already 0 or negative , return the current profit
		if(currentIndex >= weights.length  || capacity <= 0) return 0;
		
		// use current weight in the solution
		int result1 = 0;
		if(capacity >= weights[currentIndex])
			result1 = profits[currentIndex] + knapsackRecursive(weights, profits, capacity-weights[currentIndex], currentIndex+1);
		
		// don't use current weight in the solution
		int result2 = knapsackRecursive(weights, profits, capacity, currentIndex+1 );;
			
		// return whichever is bigger
		return Math.max(result1, result2);
	}
	
	/*
	 * top down dynamic programming with memoization
	 * complexity is O(N*C)
	 * N is number of items and C is capacity
	 */
	public int solveKnapsack(int[] weights,int[] profits, int capacity) {
	    Integer[][] dp = new Integer[profits.length][capacity + 1];
	    return this.knapsackRecursiveWithMem(dp, weights, profits, capacity, 0);
	  }
	
	private int knapsackRecursiveWithMem(Integer[][] dp,int[] weights, int[] profits, int capacity, int currentIndex) {
		// base condition, currentIndex falls out of array or capacity is already 0 or negative , return the current profit
		if(currentIndex >= weights.length  || capacity <= 0) return 0;
		
		if(dp[currentIndex][capacity] != null) {
			return dp[currentIndex][capacity];
		}
		
		// use current weight in the solution
		int result1 = 0;
		if(capacity >= weights[currentIndex])
			result1 = profits[currentIndex] + knapsackRecursiveWithMem(dp,weights, profits, capacity-weights[currentIndex], currentIndex+1);
		
		// don't use current weight in the solution
		int result2 = knapsackRecursiveWithMem(dp,weights, profits, capacity, currentIndex+1 );;
			
		// return whichever is bigger
		dp[currentIndex][capacity] = Math.max(result1, result2);
		return dp[currentIndex][capacity];
	}
	

}
