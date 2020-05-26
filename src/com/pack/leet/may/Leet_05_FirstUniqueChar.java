package com.pack.leet.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
public class Leet_05_FirstUniqueChar {

	public static void main(String[] args) {
		/*
		 	s = "leetcode"
			return 0.
			
			s = "loveleetcode",
			return 2.
		 */
		System.out.println(firstUniqChar("loveleetcode"));
	}
	
	public static int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int foundIndex = -1;
		for(Character c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		for(int i = 0; i < s.length(); i++) {
			if(map.get(s.charAt(i)) == 1) {
				foundIndex = i;
				break;
			}
		}
		return foundIndex;    
    }
}
