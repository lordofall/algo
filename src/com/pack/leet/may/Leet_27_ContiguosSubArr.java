package com.pack.leet.may;

import java.util.HashMap;
import java.util.Map;

public class Leet_27_ContiguosSubArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>(); // key count of 1,0 value index
		int maxLen = 0;
		map.put(0, -1); // important
		int len = nums.length;
		int movingOneZero = 0;

		for (int pos = 0; pos < len; pos++) {
			if (nums[pos] == 0) {
				movingOneZero--;
			} else {
				movingOneZero++;
			}

			if (map.containsKey(movingOneZero)) {
				int between_sub_len = pos - map.get(movingOneZero);
				maxLen = Math.max(maxLen, between_sub_len);

			} else {
				map.put(movingOneZero, pos);
			}
		}

		return maxLen;

	}

}
