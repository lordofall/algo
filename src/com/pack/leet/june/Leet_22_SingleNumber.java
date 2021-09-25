package com.pack.leet.june;
/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Input: [2,2,3,2]
Output: 3

Input: [0,1,0,1,0,1,99]
Output: 99

 */
public class Leet_22_SingleNumber {

	public static void main(String[] args) {

	}

	 public int singleNumber(int[] nums) {

	       int ones=0,twos=0,three=0;
	       for(int i=0;i<nums.length;i++){
	           twos=twos | (nums[i] &ones);
	           ones=ones^nums[i];
	           three=ones&twos;
	           ones=ones& (~three);
	           twos=twos&(~three);
	       }
	       return ones;
	   }
}
