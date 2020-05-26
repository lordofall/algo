package com.pack.practice;
/*
Least common subsequence.
Giver two sequences. find the length of longest subsequence
present in both of them. A subsequence is a sequence that appear
in the same relative order but not necessarily contiguous.
*/
public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int lcs(String s1, String s2, int i, int j) {
		if(i == s1.length() || j == s2.length() )
			return 0;
		
		// three conditions
		// i = j
		if(s1.charAt(i) == s2.charAt(j))
			return 1+ lcs(s1, s2, i+1, j+1);
		else
			return Math.max(lcs(s1, s2, i, j+1), lcs(s1, s2, i+1, j));
		
	}

}
