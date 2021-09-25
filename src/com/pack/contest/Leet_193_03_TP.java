package com.pack.contest;

import java.util.Arrays;

/*
5438. Minimum Number of Days to Make m Bouquets
Given an integer array bloomDay, an integer m and an integer k.
We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let's see what happened in the first three days. x means flower bloomed and _ means flower didn't bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

Constraints:

bloomDay.length == n
1 <= n <= 10^5
1 <= bloomDay[i] <= 10^9
1 <= m <= 10^6
1 <= k <= n
*/
public class Leet_193_03_TP {

	public static void main(String[] args) {
		Leet_193_03_TP obj = new Leet_193_03_TP();
		int[] bloomDay = {1,10,3,10,2}; int m= 3; int k = 1;
		System.out.println(obj.minDays(bloomDay, m, k));
	}

	
	public int minDays(int[] bloomDay, int m, int k) {
		if(bloomDay.length < m*k ) return -1;
		int noOfFlowers = bloomDay.length;
		Integer[][] dp = new Integer[noOfFlowers][noOfFlowers];
		
		for(int i = 0; i < noOfFlowers; i++) {
			for (int j = 0; j < noOfFlowers; j++) {
				if(bloomDay[i] >= bloomDay[j]) 
					dp[i][j] = 1;
				else dp[i][j] = -1;
			}
		}
		int noOfDays = Integer.MAX_VALUE;
		
		/*Arrays.sort(dp, (a, b) -> {
			return -1;
		});*/
		
		for(int i = 0; i < noOfFlowers; i++) {
			int x = 0; int b = 0;
			for(int j = 0; j < noOfFlowers; j++ ) {
				
				if(dp[i][j] == 1) {
					x++;
				}
				else {
					x = 0;
				}
				if(x == k) {
					b++;
					x = 0;
				}
			}
			
			if(b >= m) {
				noOfDays = Math.min(noOfDays, bloomDay[i]);
			}
		}
		return (noOfDays == Integer.MAX_VALUE) ? -1 : noOfDays;
    }
}
