package com.pack.leet.june;

import java.util.Arrays;

/*
Cheapest Flights Within K Stops
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, 
your task is to find the cheapest price from src to dst with up to k stops. 
If there is no such route, output -1.

Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200

Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500


 */
public class Leet_14_CheapestFlights {

	public static void main(String[] args) {

	}

	// DP - Bellman-Ford algorithm
	// Time Complexity for this solution is O(KN), k is stop and N is the number of cities
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //dp[i][j] denotes the cheapest price within i-1 stops, stop in j city
        long[][] dp = new long[K+2][n];
        for (long[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        dp[0][src] = 0;
        for (int i = 1; i < K+2; i++) {
            dp[i][src] = 0;
            for (int[] f : flights) {
                dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i-1][f[0]] + f[2]);
            }
        }
        return dp[K+1][dst] == Integer.MAX_VALUE ? -1 : (int)dp[K+1][dst];
	}
}
