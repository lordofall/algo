package com.pack.leet.july;

/* Find Minimum in Rotated Sorted Array II
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.
 */
public class leet_24_BST {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 2, 0, 1 };
		leet_24_BST obj = new leet_24_BST();
		System.out.println(obj.findMin(nums));
	}

	public int findMin(int[] nums) {
		return 0;
	}
	
	public int bst(int[] nums, int left, int right) {
		if(left == right)
			return nums[left];
		
		int mid = left + (right-left)/2;
		
		String s= "abc";
		s.tou
		
		
	}

}
