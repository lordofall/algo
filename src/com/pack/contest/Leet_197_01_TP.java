package com.pack.contest;

public class Leet_197_01_TP {

	public static void main(String[] args) {
		Leet_197_01_TP obj = new Leet_197_01_TP();

		int[] nums = { 1, 2, 3, 1, 1, 3 };
		System.out.println(obj.numIdenticalPairs(nums));

	}

	public int numIdenticalPairs(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j])
					count++;
			}
		}
		return count;
	}
}
