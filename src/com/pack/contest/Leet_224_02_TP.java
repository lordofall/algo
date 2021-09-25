package com.pack.contest;

import java.util.HashMap;
import java.util.Map;

public class Leet_224_02_TP {

	public static void main(String[] args) {
		Leet_224_02_TP obj = new Leet_224_02_TP();
		int[] nums = {2,3,4,6}; // 8
//		int[] nums = {1,2,4,5,10}; // 16
//		int[] nums = {2,3,4,6,8,12}; // 40
//		int[] nums = {2,3,5,7}; //0
		
		System.out.println(obj.tupleSameProduct(nums));

	}

	
	public int tupleSameProduct(int[] nums) {
		int[][] dp = new int[nums.length][nums.length];
		Map<Integer, Integer> map = new HashMap<>();
		int moreThan2 = 0;
		for(int i = 0; i < nums.length-1; i++) {
			for(int j = i+1; j <nums.length; j++ ) {
				dp[i][j] = nums[i]*nums[j];
				int valCount = map.getOrDefault(dp[i][j], 0);
				valCount++;
				map.put(dp[i][j], valCount);
			}
		}
		
		for(int val: map.values()) {
			if(val > 1) {
				int numberOfPair = val*(val-1)/2; // 
				moreThan2 += numberOfPair;
			}
		}

		return moreThan2*8;
    }
}