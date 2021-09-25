package com.pack.leet.aug21;

/**
 * 718. Maximum Length of Repeated Subarray Given two integer arrays nums1 and
 * nums2, return the maximum length of a subarray that appears in both arrays.
 * 
 * input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7] output: 3 Explanation: The
 * repeated subarray with maximum length is [3,2,1].
 * 
 * input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0] output: 5
 * 
 * Input: nums1 =[0,1,1,1,1], nums2 = [1,0,1,0,1] output = 2
 * 
 * Input: nums1: [0,0,0,0,0,0,1,0,0,0], nums2 = [0,0,0,0,0,0,0,1,0,0], output: 9
 * 
 * Input nums1: [0,1,1,1,1], nums2 = [1,0,1,0,1], output = 2
 * 
 * Input nums1: [1,2,3,2,8], nums2 = [5,6,1,4,7], output = 1
 * 
 * @author LordOfAll
 *
 */
public class RepeatedSubarray {

	public static void main(String[] args) {
		RepeatedSubarray obj = new RepeatedSubarray();
		int[] num1 = {1,2,3,2,8};
		int[] num2 = {5,6,1,4,7};
		System.out.println(obj.findLength(num1, num2));
	}
	/**
	 * 
	 * @return
	 */
	public int findLength(int[] nums1, int[] nums2) {
		
		int result = 0;
		
		int[][] dp = new int[nums1.length][nums2.length];
		
		// fill first row
		for(int i = 0; i < nums1.length; i++) {
			if(nums1[i] == nums2[0]) {
				dp[i][0] = 1;
				result = 1;
			}
		}
		// fill first col
		for(int j = 0; j < nums2.length; j++) {
			if(nums2[j] == nums1[0]) {
				dp[0][j] = 1;
				result = 1;
			}
		}
		
		// if nums1[i] = nums2[j], dp[i][j] = dp[i-1][j-1] + 1
		// else  dp[i][j] = 0 
		for(int i = 1; i < nums1.length; i++) {
			for(int j = 1; j< nums2.length; j++) {
				
				if(nums1[i] == nums2[j]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				if(result < dp[i][j])
					result = dp[i][j];
			}
		}
		
		return result;
	}
}
