package com.pack.leet.june;
/*
Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Input: [1,3,5,6], 5
Output: 2

Input: [1,3,5,6], 2
Output: 1

Input: [1,3,5,6], 7
Output: 4

Input: [1], 1
Output: 0
 */
public class Leet_10_BST {

	public static void main(String[] args) {
		Leet_10_BST obj = new Leet_10_BST();
		int[] nums = {1};
		int target = 1;
		System.out.println(obj.searchInsert(nums, target));
	}

	// ACCEPTED
	public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

	private int search(int[] nums, int target, int lo, int hi) {
		if(lo == hi) {
			return nums[lo] < target ? lo+1 : lo; 
		}
		int mid = lo + (hi-lo)/2;
		
		if(nums[mid] == target) return mid;
		
		if(target < nums[mid]) return search(nums, target, lo, mid);
		else return search(nums, target, mid+1, hi);
	}
}
