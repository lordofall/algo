package com.pack.leet.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Largest Divisible Subset
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.
 */
public class Leet_13_LargestDivisibleSubset {

	List<Integer> result = null;

	public static void main(String[] args) {
		Leet_13_LargestDivisibleSubset obj = new Leet_13_LargestDivisibleSubset();
		int[] nums = { 1, 2, 3 };
		System.out.println(obj.largestDivisibleSubset(nums));
	}

	// Largest Increasing subsequence problem
	public List<Integer> largestDivisibleSubset(int[] nums) {

		if (nums.length == 0)
			return new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();
		int len = nums.length;
		Arrays.sort(nums); // 1, 2, 3, 4, 5 , 6
		for (int d : nums) {
			List<Integer> l = new ArrayList<>();
			l.add(d);
			map.put(d, l);
		}

		for (int i = len - 2; i >= 0; i--) {
			int max = 0;
			int key = nums[i];
			for (int j = i + 1; j < len; j++) {
				if (nums[j] % nums[i] == 0) {
					int x = nums[j];
					if (max < map.get(x).size()) {
						max = map.get(x).size();
						key = x;
					}
				}
			}

			if (key != nums[i])
				map.get(nums[i]).addAll(map.get(key));
		}

		List<Integer> result = null;
		int max = 0;
		for (Integer key : map.keySet()) {
			if (map.get(key).size() > max) {
				max = map.get(key).size();
				result = map.get(key);
			}
		}

		return result;
	}

	public List<Integer> largestDivisibleSubset1(int[] nums) {

		result = new ArrayList<>();
		if (nums.length == 0)
			return result;

		int len = nums.length;
		Arrays.sort(nums);
		int[] arrayLengthUsing = new int[len];
		List<Integer> curr = new ArrayList<>();
		Arrays.fill(arrayLengthUsing, -1);
		for (int i = 0; i < len; i++) {
			dfs(nums, i, arrayLengthUsing, curr);
		}
		return result;
	}

	private void dfs(int[] nums, int idx, int[] arrayLengthUsing, List<Integer> curr) {
		if (idx == nums.length)
			return;

		if (arrayLengthUsing[idx] > 0) {
			return;
		}
		curr.add(nums[idx]);

		for (int i = idx + 1; i < nums.length; i++) {
			if (nums[i] % nums[idx] == 0) {
				dfs(nums, i, arrayLengthUsing, curr);
				arrayLengthUsing[i] = arrayLengthUsing[idx] + 1;// learnt this today
			}
		}

		if (curr.size() > result.size()) {
			result = new ArrayList<>(curr);

		}
		if (curr.size() > 0)
			curr.remove(curr.size() - 1);

	}
}
