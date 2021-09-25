package com.pack.contest;

public class Leet_227_01_TP {

	public static void main(String[] args) {
		Leet_227_01_TP obj = new Leet_227_01_TP();

//		int[] nums = { 3, 4, 5, 1, 2 };// true
//		int[] nums = { 2,1,3,4 };// false
//		int[] nums = { 1,2,3 };// true
//		int[] nums = { 1,1,1 };// true
//		int[] nums = { 2,1};// true
		int[] nums = { 3,7,10,6,7,7};// false
		System.out.println(obj.check(nums));		

	}
	
	public boolean check(int[] nums) {
		boolean result = true;
		boolean valueChanged = false;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i-1] <= nums[i]) {
				if(valueChanged && nums[i] > nums[0]) {
					return false;
				}
			}
		    else {
				if(!valueChanged) 
					valueChanged = true;
				else
					return false;
			}
		}
		return result;
	}
}
	

