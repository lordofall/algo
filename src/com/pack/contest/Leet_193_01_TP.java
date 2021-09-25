package com.pack.contest;

import java.util.Arrays;

/*
5436. Running Sum of 1d Array

Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i])
Return the running sum of nums.

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */
public class Leet_193_01_TP {

	public static void main(String[] args) {
		Leet_193_01_TP obj = new Leet_193_01_TP();
		int[] nums = {1,2,3,4};
		System.out.println(Arrays.toString(obj.runningSum(nums)));
	}

	
	public int[] runningSum2(int[] nums) {
        int[] result = new int[nums.length];
		result[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
			result[i] = nums[i] + result[i-1];
		}
		return result;
    }
	public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j <= i; j++) {
				result[i] += nums[j];
			}
		}
		return result;
    }
}
