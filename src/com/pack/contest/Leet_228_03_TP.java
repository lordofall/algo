package com.pack.contest;

import java.util.Arrays;

/**
 * 5678. Minimum Limit of Balls in a Bag
 * 
 * @author LordOfAll
 *
 */
public class Leet_228_03_TP {

	public static void main(String[] args) {
		Leet_228_03_TP obj = new Leet_228_03_TP();

		/*int[] nums = { 9 };// 3
		int maxOperations = 2;*/
		
		int[] nums = { 2,4,8,2 };// 2
		int maxOperations = 4;
		
		/*int[] nums = { 7,17 };// 7
		int maxOperations = 2;*/
		

		System.out.println(obj.minimumSize(nums, maxOperations));

	}

	public int minimumSize(int[] nums, int maxOperations) {
		Arrays.sort(nums);
		int length = nums.length;
		int rindex = length - 1;
		int noTobeDivided = nums[rindex];
		while (maxOperations != 0) {
			int first = noTobeDivided / (maxOperations + 1);
			if(rindex-1 >= 0 && first < nums[rindex-1]) {
				first = nums[rindex-1];
			}
			int second = noTobeDivided - first;
			noTobeDivided = Math.max(first, second);
			if(rindex-1 >= 0 && nums[rindex-1] > noTobeDivided) {
				noTobeDivided = nums[rindex-1];
				rindex--;
			}
			
			maxOperations--;
		}

		return noTobeDivided;
	}
}
