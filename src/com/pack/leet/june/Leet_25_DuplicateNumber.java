package com.pack.leet.june;
/*
Find the Duplicate Number
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
Input: [1,3,4,2,2]
Output: 2

Input: [3,1,3,4,2]
Output: 3

Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.


 */
public class Leet_25_DuplicateNumber {

	public static void main(String[] args) {
		Leet_25_DuplicateNumber obj = new Leet_25_DuplicateNumber();
		int[] nums = {1,3,4,2,2};
		System.out.println(obj.findDuplicate(nums));
	}
	
	public int findDuplicate(int[] nums) {
		// Find the intersection point of the two runners.
	    int tortoise = nums[0];
	    int hare = nums[0];
	    do {
	      tortoise = nums[tortoise];
	      hare = nums[nums[hare]];
	    } while (tortoise != hare);

	    // Find the "entrance" to the cycle.
	    tortoise = nums[0];
	    while (tortoise != hare) {
	      tortoise = nums[tortoise];
	      hare = nums[hare];
	    }

	    return hare;
    }

}
