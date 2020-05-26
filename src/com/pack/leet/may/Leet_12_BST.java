package com.pack.leet.may;
/*
 You are given a sorted array consisting of only integers where every element appears exactly twice, 
 except for one element which appears exactly once. 
 Find this single element that appears only once.
 
 Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Input: [3,3,7,7,10,11,11]
Output: 10
 */
public class Leet_12_BST {

	public static void main(String[] args) {
		int[] nums = new int[] {1,1,2,3,3,4,4,8,8};
//		int[] nums = new int[] {1,2,2};
//		int[] nums = new int[] {3,3,7,7,10,11,11};
		System.out.println(singleNonDuplicate(nums));
	}

	static int singleNonDuplicate(int[] nums) {
		
		return singleNonDuplicate(nums, 0, nums.length-1);
    }
	
	static int singleNonDuplicate(int[] nums, int start, int end) {
		if(start == end) {
			return nums[start];
		}
		
		int mid = start + (end-start)/2;
		
		if(nums[mid] == nums[mid-1]) { // check left
			if((mid-1-start)%2 != 0)
				return singleNonDuplicate(nums, start, mid-2);
			else
				return singleNonDuplicate(nums, mid+1, end);
		}
		else if(nums[mid] == nums[mid+1]) {// check right
			if((end-mid-1) % 2 != 0) {
				return singleNonDuplicate(nums, mid+2, end);
			}
			else {
				return singleNonDuplicate(nums, start, mid-1);
			}
		}	
		else
			return nums[mid];
	
	}
}
