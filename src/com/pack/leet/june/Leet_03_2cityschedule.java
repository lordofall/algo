package com.pack.leet.june;

import java.util.Arrays;

/*
There are 2N people a company is planning to interview. 
The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city 
such that exactly N people arrive in each city.
Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
*/
public class Leet_03_2cityschedule {

	public static void main(String[] args) {
		Leet_03_2cityschedule obj = new Leet_03_2cityschedule();
		int[][] costs = new int[][] {
			new int[] {10,20},new int[] {30,200},
			new int[] {400,50},new int[] {30,20}
		};
		
		System.out.println(obj.twoCitySchedCost(costs));
	}
	
	public int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
		int minCost = 0;
		for (int i = 0; i < costs.length / 2; i++) {
			minCost += costs[i][0]; // send first n to A
			minCost += costs[costs.length / 2 + i][1];
		}
		return minCost;
	}

}
