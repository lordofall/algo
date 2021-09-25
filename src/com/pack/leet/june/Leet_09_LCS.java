package com.pack.leet.june;
/*
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
Input: s = "abc", t = "ahbgdc"
Output: true
Input: s = "", t = "ahbgdc"
Output: true

*/
public class Leet_09_LCS {

	public static void main(String[] args) {
		Leet_09_LCS obj = new Leet_09_LCS();
		String s = "abc";
		String t = "ahbgd";
		System.out.println(obj.isSubsequence(s, t));
	}

	public boolean isSubsequence(String s, String t) {
		if(s.length() == 0) return true; // s = ""
		int[][] dp = new int[s.length()+1][t.length()+1];
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < t.length(); j++) {
				
				if(s.charAt(i) == t.charAt(j)) dp[i+1][j+1] = 1 + dp[i][j];
				else dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				
				if(dp[i+1][j+1] == s.length()) return true;
			}
		}
        return false;
    }
}
