package com.pack.leet.aug21;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the
 * length of 3.
 * 
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length
 * of 1.
 * 
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the
 * length of 3. Notice that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * Input: s = "" Output: 0
 * 
 * Constraints: 0 <= s.length <= 5 * 104 s consists of English letters, digits,
 * symbols and spaces.
 * 
 * s="dvdf" 
 * output: 3
 * 
 * s = "anviaj"
 * output: 5
 * 
 * @author LordOfAll
 *
 */
public class LongestSubstring3 {
	Map<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		LongestSubstring3 obj = new LongestSubstring3();
		String s = "bbbbb";
		System.out.println(obj.lengthOfLongestSubstring(s));
	}
	/**
	 * iterate the string
	 * for each character, check in the map whether it has already come. ie. if size is 1, then it has come before.
	 * if size is 0, update the map and also increase the maxLength.
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int currentMaxlength = 0;
		int startIndex = 0;
		int currentIndex = 0;
		while(currentIndex < s.length()) {
			char c = s.charAt(currentIndex);
			if(map.getOrDefault(c, 0) == 0) {
				map.put(c, 1);
				currentMaxlength++;
				currentIndex++;
			}
			else {
				if(currentMaxlength > maxLength) {
					maxLength = currentMaxlength;
				}
				startIndex++;
				currentIndex = startIndex;
				currentMaxlength = 0;
				map.clear();
			}
		}
		if(currentMaxlength > maxLength) {
			maxLength = currentMaxlength;
		}
		return maxLength;
	}
}
