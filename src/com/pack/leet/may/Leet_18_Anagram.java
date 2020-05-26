package com.pack.leet.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

 */
public class Leet_18_Anagram {

	public static void main(String[] args) {
		String str1 = "cbaebabacd";
		String str2 = "abc";
		System.out.println(findAnagrams(str1, str2));

	}
	
	public static List<Integer> findAnagrams(String s, String p) {
    
		List<Integer> list = new ArrayList<>();
		char[] parr = p.toCharArray();
		Arrays.sort(parr);
		
		for(int i = 0; i < s.length()-p.length()+1; i++) {
			if(isAnagram(s.substring(i, i+p.length()).toCharArray(), parr)) {
				list.add(i);
			}
		}
		return list;
    }
	
	static boolean isAnagram(char[] arr1, char[] arr2) {
		Arrays.sort(arr1); // arr2 is already sorted in the calling method
		return Arrays.equals(arr1, arr2);
	}

}
