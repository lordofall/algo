package com.pack.educative.dp;
/**
 * Given a set of positive numbers, find if we can partition it 
 * into two subsets 
 * such that the sum of elements in both the subsets is equal.
 * 
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned 
 * into two subsets with equal sum: {1, 4} & {2, 3}
 * @author LordOfAll
 *
 */
public class EqualSubsetSum {

	public static void main(String[] args) {
		int[] arr = {2,2,3,3, 4, 10};
		EqualSubsetSum obj = new EqualSubsetSum();
		System.out.println(obj.equalSubsetSum(arr));
	}

	private boolean equalSubsetSum(int[] arr) {
		int total = 0;
		for(int i: arr) {
			total+=i;
		}
		// if total is odd number, then its not possible to divide in equal
		if(total % 2 != 0) return false;
		
		int capacity = total/2;
		
//		return equalSubsetSum(arr, 0, capacity);
//		Boolean[][] dp = new Boolean[arr.length][capacity+1];
//		return equalSubsetSum(dp, arr, 0, capacity);
		
		return equalSubsetSum(arr, capacity);
	}

	// recursion
	private boolean equalSubsetSum(int[] arr, int currentIndex, int capacity) {
		if(capacity == 0) return true;
		if(capacity < 0 || currentIndex >= arr.length) return false;
		
		// use current index
		boolean flag1 = equalSubsetSum(arr, currentIndex+1, capacity-arr[currentIndex]);
		boolean flag2 = equalSubsetSum(arr, currentIndex+1, capacity);
		
		return flag1 || flag2;
	}
	
	// recursion with memoization (Top down approach)
	// time and space complexity of O(N*S), O(N*S), 
	// where 'N' represents total numbers and 'S' is the total sum of all the numbers.
	private boolean equalSubsetSum(Boolean[][] dp, int[] arr, int currentIndex, int capacity) {
		
		if(capacity == 0) return true;
		if(capacity < 0 || currentIndex >= arr.length) return false;
		
		if(dp[currentIndex][capacity] != null) return dp[currentIndex][capacity];
		
		// use current index
		boolean flag1 = equalSubsetSum(arr, currentIndex+1, capacity-arr[currentIndex]);
		boolean flag2 = equalSubsetSum(arr, currentIndex+1, capacity);
		dp[currentIndex][capacity] = flag1 || flag2;
		return flag1 || flag2;
	}

	// Bottom up approach
	// The time and space complexity of O(N*S)O(N*S), 
	// where ‘N’ represents total numbers and 'S' is the total sum of all the numbers.
	private boolean equalSubsetSum(int[] arr, int capacity) {
		int rows = arr.length;
		int cols = capacity+1;
		Boolean[][] dp = new Boolean[rows][cols];
		// fill first row
		for(int c = 0; c < cols; c++) {
			dp[0][c] = (c == arr[0]);
		}
		
		// fill first col; always true, we can always have '0' sum, without including any item
		for(int i = 0; i < rows; i++) {
			dp[i][0] = true;
		}
		
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				boolean including = false;
				if(j-arr[i] >0) {
					including = dp[i-1][j-arr[i]];
				}
				dp[i][j] = dp[i-1][j] || including;
			}
		}
		return dp[rows-1][cols-1];
	}
}
