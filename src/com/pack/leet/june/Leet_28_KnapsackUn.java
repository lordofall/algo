package com.pack.leet.june;
/*
Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.


Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/
public class Leet_28_KnapsackUn {

	public static void main(String[] args) {

	}

	public int numSquares(int n) {
		int weights = findNearestSqrNumber(n);
		return knapsackWithUnBounded(weights, n);
	}

	private int findNearestSqrNumber(int n) {
		int i = 1;
		int prev = 0;
		while (true) {
			if (i * i <= n) {
				prev = i;
				i++;
			} else {
				break;
			}
		}
		return prev;
	}

	public int knapsackWithUnBounded(int n, int capacity) {
		if (capacity == 0 || n == 1)
			return capacity;

		int p1 = Integer.MAX_VALUE;
		if (capacity >= n * n) {
			int count1 = capacity / (n * n);
			p1 = count1 + knapsackWithUnBounded(n - 1, capacity - count1 * n * n);
		}

		int p2 = knapsackWithUnBounded(n - 1, capacity);
		return Math.min(p1, p2);
	}
}
