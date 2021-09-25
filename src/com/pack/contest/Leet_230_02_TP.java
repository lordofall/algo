package com.pack.contest;

/**
 * 5690. Closest Dessert Cost
 * 
 * @author LordOfAll
 *
 */
public class Leet_230_02_TP {

	public static void main(String[] args) {
		Leet_230_02_TP obj = new Leet_230_02_TP();

		int[] baseCosts = { 1, 7 };
		int[] toppingCosts = { 3, 4 };
		int target = 10;
		System.out.println(obj.closestCost(baseCosts, toppingCosts, target));

	}

	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		int result = 0;
		for(int i = 0; i < baseCosts.length; i++) {
			int tempResult = closestCost(toppingCosts, target, 0, baseCosts[i]);
		}
	}

	private int closestCost(int[] toppingCosts, int target, int toppingIndex, int cost) {
		if(toppingIndex == toppingCosts.length)
			return cost;
		int cost1 = cost;
		int cost2 = cost ;
		int cost3 = cost;
		
		if(cost < target)
			cost1 = closestCost(toppingCosts, target, toppingIndex+1, cost); // dont use topping
		
		if(cost + toppingCosts[toppingIndex] < target)
			cost2 = closestCost(toppingCosts, target, toppingIndex+1, cost + toppingCosts[toppingIndex]); // 1 topping
		
		if(cost + toppingCosts[toppingIndex]*2 < target)
			cost3 = closestCost(toppingCosts, target, toppingIndex+1, cost + toppingCosts[toppingIndex]*2); // 2 toppings
		

		
		
		return 0;
	}
	
	
	

}
