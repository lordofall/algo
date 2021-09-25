package com.pack.contest.sept;

public class Leet_208_02_TP {

	public static void main(String[] args) {
		Leet_208_02_TP obj = new Leet_208_02_TP();

		int[] customers = {10,10,6,4,7};
		int boardingCost = 3;
		int runningCost = 8; // result = 9
		System.out.println(obj.minOperationsMaxProfit(customers, boardingCost, runningCost));
	}

	
	public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
		int totalCustomers = 0;
		for(int customer: customers) {
			totalCustomers+=customer;
		}
		
		int totalRotation = customers.length;
		
		int temp = totalCustomers/4;
		if(totalCustomers %4 > 0)
			temp = temp+1;
		
		if(temp > totalRotation)
			totalRotation = temp;
		if(boardingCost*totalCustomers - totalRotation*runningCost < 0) {
			totalRotation = -1;
		}
		
		return totalRotation;
    }

}
