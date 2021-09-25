package com.pack.leet.june;

import java.util.Arrays;

/*
Sort Colors
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: You are not suppose to use the library's sort function for this problem.

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
*/
public class Leet_11_SortColors {

	public static void main(String[] args) {
		Leet_11_SortColors obj = new Leet_11_SortColors();
		int[] nums = {1,0,1};
		obj.sortColors2(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public void sortColors2(int[] nums) {
		int l = 0; 
		int r = nums.length-1;
		int i = 0;
		while( l < r && i <= r) {
			if(nums[i] == 2) {
				swap(nums, i, r); r--;
			}
			else if(nums[i] == 0) {
				swap(nums, i, l); l++; i++;
			}
			else {
				i++;
			}
		}
	 }
	
	 private void swap(int[] nums, int l, int r) {
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}

	public void sortColors(int[] nums) {
		 int[] colors = {0,0,0};
		 for(int i: nums) {
			 if(i == 0) colors[0]++;
			 if(i == 1) colors[1]++;
			 if(i == 2) colors[2]++;
		 }
		 int j = 0;
		 for(int i = 0; i < colors[0]; i++)
			 nums[j++] = 0;
		 for(int i = 0; i < colors[1]; i++)
			 nums[j++] = 1;
		 for(int i = 0; i < colors[2]; i++)
			 nums[j++] = 2;
	 }

}
