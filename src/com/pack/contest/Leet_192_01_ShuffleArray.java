package com.pack.contest;

import java.util.Arrays;

/*
Shuffle the Array
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7] 
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

 */
public class Leet_192_01_ShuffleArray {

	public static void main(String[] args) {
		int[] nums = new int[] {2,5,1,3,4,7};
		int n = 3;
		Leet_192_01_ShuffleArray obj = new Leet_192_01_ShuffleArray();
		System.out.println(Arrays.toString(obj.shuffle(nums, n)));

	}

	
	 public int[] shuffle(int[] nums, int n) {
		 int[] result = new int[2*n];
		 int i = 0, k = 0;
		 while(i < n) {
			 result[k] = nums[i];
			result[++k] = nums[n+i];
			i++; k++;
		 }
		 return result;
	 }
}
