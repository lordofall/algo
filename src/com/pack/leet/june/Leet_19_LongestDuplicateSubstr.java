package com.pack.leet.june;

import java.util.HashMap;
import java.util.Map;

/*
Longest Duplicate Substring
Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)

Input: "banana"
Output: "ana"
 */
public class Leet_19_LongestDuplicateSubstr {

	public static void main(String[] args) {
		Leet_19_LongestDuplicateSubstr obj = new Leet_19_LongestDuplicateSubstr();
		System.out.println(obj.longestDupSubstring("banana"));
	}

	int p = (int) Math.pow(10, 7) + 7;
	int[] roll;

	String longestDupSubstring(String S) {

		int len = S.length();
		if (len == 0)
			return "";

		roll = new int[len];
		roll[0] = 1; // Since 26^0 = 1
		for (int i = 1; i < len; ++i)
			roll[i] = (26 * roll[i - 1]) % p;

		int low = 1, high = len, mid;
		String ans = "", temp;
		while (low <= high) {
			temp = "";
			mid = low + (high - low) / 2;
			String result = match(S, len, mid);
			if (result.length() > 0) {
				if (result.length() > ans.length())
					ans = result;
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return ans;
	}

	private String match(String s, int len, int size) {
		String resut = "";
		Map<Integer, Integer> map = new HashMap<>();
		int hash = 0; // curr window hash
		for (int i = 0; i < size; ++i)
			hash = (hash * 26 + (s.charAt(i) - 'a')) % p;
		map.put(hash, 0);

		for (int j = size; j < len; ++j) {
			hash = ((hash - roll[size - 1] * (s.charAt(j - size) - 'a')) % p + p) % p;
			hash = (hash * 26 + (s.charAt(j) - 'a')) % p;

			if (map.containsKey(hash)) {

				int start = map.get(hash);
				String temp = s.substring(start, start + size);
				String curr = s.substring(j - size + 1, j - size + 1 + size);
				if (temp.equals(curr)) {
					resut = temp;
					break;
				}
			}
			map.put(hash, j - size + 1);
		}
		return resut;
	}

}