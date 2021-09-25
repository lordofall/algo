package com.pack.educative.dp;
/**
 * Given a set of positive numbers (non zero) and a target sum ‘S’. Each number should be assigned either a ‘+’ or ‘-’ sign. We need to find out total ways to assign symbols to make the sum of numbers equal to target ‘S’.
 * @author LordOfAll
 * 
 * Input: {1, 1, 2, 3}, S=1
 *Output: 3
 *Explanation: The given set has '3' ways to make a sum of '1':
 * {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}
 *
 */
public class TargetSum {

	public static void main(String[] args) {
		// either or
		TargetSum obj = new TargetSum();
//		int[] arr = {1, 1, 2, 3};
//		int s=1; // output: 3
		int[] arr = {1, 2, 7, 1};
		int s=9; // output: 3
		System.out.println(obj.targetSum(arr, s, 0, 0));
	}

	private int targetSum(int[] arr, int s, int currentIndex, int sum) {
		
		if(currentIndex == arr.length) {
			if(sum == s)
				return 1;
			else
				return 0;
		}
		
		// if +  chosen
		int a = targetSum(arr, s, currentIndex+1, sum+arr[currentIndex]);
		
		int b = targetSum(arr, s, currentIndex+1, sum-arr[currentIndex]);
		
		return a+b;
	}
	
	

}
