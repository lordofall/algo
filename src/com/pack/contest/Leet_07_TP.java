package com.pack.contest;

import java.util.Arrays;

/*
Given two arrays nums1 and nums2.
Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
Output: 18
Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
Their dot product is (2*3 + (-2)*(-6)) = 18.

Input: nums1 = [3,-2], nums2 = [2,-6,7]
Output: 21
Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
Their dot product is (3*7) = 21.

Input: nums1 = [-1,-1], nums2 = [1,1]
Output: -1
Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
Their dot product is -1.

Input:
[5,-4,-3]
[-4,-3,0,-4,2]
output: 28

Input:
[2,1,-2,5]
[3,0,-6]
output: 18

Input:
[-1,-1]
[1,1]
output: -1

Input:
[-5,-1,-2]
[3,3,5,5]
Output: -3
*/
public class Leet_07_TP {

	int[][] mem = null;
	public static void main(String[] args) {
		int[] nums1 = new int[] {5,-4,-3};
		int[] nums2 = new int[] {-4,-3,0,-4,2};
		System.out.println(new Leet_07_TP().maxDotProduct(nums1, nums2));
		
	}
	
	public int maxDotProduct(int[] nums1, int[] nums2) {
       mem = new int[nums1.length][nums2.length];
       for(int[] x: mem) {
    	   Arrays.fill(x, Integer.MIN_VALUE);
       }
		return maxDotProduct(nums1, nums2, 0, 0);
       
    }

	private int maxDotProduct(int[] nums1, int[] nums2, int i, int j) {
			
		if(mem[i][j] > Integer.MIN_VALUE) return mem[i][j];
		
		int res0 = nums1[i]*nums2[j];
		int res1 = nums1[i]*nums2[j] + ((i+1 < nums1.length && j+1 < nums2.length) ? maxDotProduct(nums1, nums2, i+1, j+1): 0);
		int res2 = (i < nums1.length && j+1 < nums2.length) ? maxDotProduct(nums1, nums2, i, j+1): Integer.MIN_VALUE;
		int res3 = (i+1 < nums1.length && j < nums2.length) ?  maxDotProduct(nums1, nums2, i+1, j): Integer.MIN_VALUE;
		int res4 = (i+1 < nums1.length && j+1 < nums2.length) ?  maxDotProduct(nums1, nums2, i+1, j+1): Integer.MIN_VALUE;
		
		int res = Math.max(Math.max(Math.max(Math.max(res1, res2), res3), res4), res0);
		mem[i][j] = res;
		return res;
	}
	
	
	// copied from leetcode
    public int maxDotProduct2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, max = Integer.MIN_VALUE;
        if (m < n) {
            return maxDotProduct(nums2, nums1);
        }
        int[] dp = new int[n + 1];
        for (int n1 : nums1) {
            for (int i = 0, prevRowPrevCol = 0, prevCol = 0; i < nums2.length; ++i) {
                int p = n1 * nums2[i];
                max = Math.max(p, max);
                p = Math.max(p, 0);
                prevRowPrevCol = prevCol;
                prevCol = dp[i + 1];
                dp[i + 1] = Math.max(prevRowPrevCol + p, Math.max(dp[i], dp[i + 1]));
            }
        }
        return max <= 0 ? max : dp[n];
    }

}
