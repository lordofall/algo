package com.pack.contest;
/* ACCEPTED
 
Maximum Product of Two Elements in an Array

Given the array of integers nums, you will choose two different indices i and j of that array. 
Return the maximum value of (nums[i]-1)*(nums[j]-1).

Input: nums = [3,4,5,2]
Output: 12 
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 
 */
public class Leet_191_01_TP {

	public static void main(String[] args) {
		Leet_191_01_TP obj = new Leet_191_01_TP();
		int[] nums = new int[] {3,4,5,2};
		System.out.println(obj.maxProduct(nums));
	}

	public int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(i != j) {
					max = Math.max(max, (nums[i]-1)*(nums[j]-1) );
				}
			}
		}
		return max;
	}
}
