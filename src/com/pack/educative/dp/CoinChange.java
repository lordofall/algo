package com.pack.educative.dp;

/** Unbounded Knapsack
 * Given an infinite supply of ‘n’ coin denominations and a total money
amount, we are asked to find the total number of distinct ways to
make up that amount.
Denominations: {1,2,3}
Total amount: 5
Output: 5
Explanation: There are five ways to make the change for '5',
here are those ways:
1. {1,1,1,1,1}
2. {1,1,1,2}
3. {1,2,2}
4. {1,1,3}
5. {2,3}
 * @author LordOfAll
 *
 */
public class CoinChange {

	public static void main(String[] args) {
		CoinChange obj = new CoinChange();
		int[] denominations = {1,2,3};
		int total = 5;
		
		// recursion only
		// System.out.println(obj.noOfWays(denominations, total, 0));
		
		// recursion with memoization
		Integer[][] mem = new Integer[denominations.length][total+1];
		System.out.println(obj.noOfWays(mem,denominations, total, 0));
	}
	
	// Recursive way
	private int noOfWays(int[] denominations, int total, int currentIndex) {
		if(total == 0) return 1;
		if(currentIndex >= denominations.length || total < 0) return 0;

		// include denominations[i]
		int a = noOfWays(denominations, total - denominations[currentIndex], currentIndex);
		// exclude denominations[i]
		int b = noOfWays(denominations, total, currentIndex+1);
		return a+b;
	}
	
	// recursion with memoization
	private int noOfWays(Integer[][] mem, int[] denominations, int total, int currentIndex) {
		// write base condition first
		if(total == 0) return 1;
		if(currentIndex >= denominations.length || total < 0) return 0;
		
		// check if result is there in mem
		if(mem[currentIndex][total] != null)
			return mem[currentIndex][total];
		
		// include denominations[i]
		int a = noOfWays(denominations, total - denominations[currentIndex], currentIndex);
		// exclude denominations[i]
		int b = noOfWays(denominations, total, currentIndex+1);
		int result = a + b;
		
		// put the result in mem
		mem[currentIndex][total] = result;
		return result;
	}
}
