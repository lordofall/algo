package com.pack.leet.may;

/*
 Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
 In other words, one of the first string's permutations is the substring of the second string.
 
Input: s1 = "ab" s2 = "eidbaooo"
Output: True

Input:s1= "ab" s2 = "eidboaoo"
Output: False

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 */
public class Leet_19_Permutation {

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidboaoo";
		System.out.println(checkInclusion(s1, s2));

	}
	
	public static boolean checkInclusion(String s1, String s2) {
		for(int i = 0; i < s2.length()-s1.length()+1; i++) {
			if(isAnagram(s1,s2.substring(i, i+s1.length()))) {
				return true;
			}
		}    
		return false;
    }
	
	static boolean isAnagram(String str1, String str2) {
		int[] arr = new int[26]; // 
		
		for(int i=0; i < str1.length(); i++) {
			arr[str1.charAt(i)-'a'] +=1;
			arr[str2.charAt(i)-'a'] -=1;
		}
		
		for(int i: arr) {
			if(i != 0) { // for anagram, all values should be zero
				return false;
			}
		}
		return true;
	}

}
