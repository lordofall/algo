package com.pack.contest;

import java.util.Arrays;

/**
 * 5685. Merge Strings Alternately
 * 
 * @author LordOfAll
 *
 */
public class Leet_229_01_TP {

	public static void main(String[] args) {
		Leet_229_01_TP obj = new Leet_229_01_TP();
//		String word1 = "abc", word2 = "pqr"; // apbqcr
//		String word1 = "ab", word2 = "pqrs"; // apbqrs
		String word1 = "abcd", word2 = "pq"; // apbqrs

		System.out.println(obj.mergeAlternately(word1, word2));

	}

	 public String mergeAlternately(String word1, String word2) {
		 StringBuilder merged = new StringBuilder();
		 int len1 = word1.length();
		 int len2 = word2.length();
		 if(len1 < len2) {
			 for(int i = 0; i < len1; i++) {
				 merged.append(String.valueOf(word1.charAt(i)));
				 merged.append(String.valueOf(word2.charAt(i)));
			 }
			 
			 merged.append(word2.substring(len1, len2));
		 }
		 else {
			 for(int i = 0; i < len2; i++) {
				 merged.append(String.valueOf(word1.charAt(i)));
				 merged.append(String.valueOf(word2.charAt(i)));
			 }
			 
			 merged.append(word1.substring(len2, len1));
		 }
		 return merged.toString();
	 }
}
