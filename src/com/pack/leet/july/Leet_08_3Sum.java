package com.pack.leet.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.util.Pair;

public class Leet_08_3Sum {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		Leet_08_3Sum obj = new Leet_08_3Sum();
		System.out.println(obj.threeSum(nums).toString());

	}

	public List<List<Integer>> threeSum(int[] nums) {

		int len = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		Set<Pair<Integer, Integer>> set = new HashSet<>();
		for (int i = 0; i < len - 2; i++) {

			int j = i + 1;
			int k = len - 1;
			while (j < k) {

				if (nums[j] + nums[k] + nums[i] > 0) {
					k--;
				} else if (nums[j] + nums[k] + nums[i] < 0) {
					j++;
				} else {

					if (!set.contains(new Pair(nums[i], nums[j]))) {
						set.add(new Pair(nums[i], nums[j]));
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					}

					j++;
					k--;
				}
			}

		}

		return result;

	}

}

//class Pair<T1, T2> {
//	T1 num1;
//	T2 num2;
//
//	public Pair(T1 num1, T2 num2) {
//		this.num1 = num1;
//		this.num2 = num2;
//	}
//}
