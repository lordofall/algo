package com.pack.leet.aug21;

import java.util.ArrayList;
import java.util.List;

/**
 * 1004. Max Consecutive Ones III
 * 
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * 
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * 
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * 
 * Input: nums = [1,1,1,0,0,0,1,1,1,1], k = 0
 * output: 4
 * 
 * @author LordOfAll
 *
 */
public class MaxConsecutiveOne1004 {

	public static void main(String[] args) {

		MaxConsecutiveOne1004 obj = new MaxConsecutiveOne1004();
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k = 3;
		System.out.println(obj.longestOnes(nums, k));
	}

	public int longestOnes(int[] nums, int k) {
		int result = 0;
		int currentResult = 0;
		List<Integer> flippedIndexList = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) {
				currentResult++;
			}
			else { // nums[i] == 0
				if( k > 0) {
					currentResult++;
					k--;
					flippedIndexList.add(i);
				}
				else { // k = 0
					if(result < currentResult)
						result = currentResult;
					
					if(flippedIndexList.size() > 0) {
						currentResult = (i - flippedIndexList.get(0));
						flippedIndexList.remove(0);
						flippedIndexList.add(i);
					}
					else {
						currentResult = 0;
					}
				}
			}
		}
		
		if(result < currentResult)
			result = currentResult;
		
		return result;
    }
	
	
	/**
	 * For each A[j], try to find the longest subarray.
	 * If A[i] ~ A[j] has zeros <= K, we continue to increment j.
	 * If A[i] ~ A[j] has zeros > K, we increment i (as well as j).
	 * @param A
	 * @param K
	 * @return
	 */
	public int longestOnes1(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }
}
