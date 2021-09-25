package com.pack.leet.july;

import java.util.ArrayList;
import java.util.List;

/*
Subsets
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Leet_11_Subsets {

	public static void main(String[] args) {
		Leet_11_Subsets obj = new Leet_11_Subsets();
		int[] nums = { 1, 2, 3 };
		System.out.println(obj.subsets(nums).toString());
	}

	public List<List<Integer>> subsets(int[] arr) {
		List<Integer> curr = new ArrayList<Integer>();
		List<List<Integer>> ans = new ArrayList<>();
		rec(arr, 0, curr, ans);
		return ans;
	}

	private void rec(int[] arr, int i, List<Integer> curr, List<List<Integer>> ans) {
		if (i == arr.length) {
			ans.add(new ArrayList<Integer>(curr));
			return;
		}
		curr.add(arr[i]);
		rec(arr, i + 1, curr, ans);
		curr.remove(curr.size() - 1);
		rec(arr, i + 1, curr, ans);
	}
}
