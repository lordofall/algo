package com.pack.contest;
/*
 Given a sentence that consists of some words separated by a single space, and a searchWord.
You have to check if searchWord is a prefix of any word in sentence.
Return the index of the word in sentence where searchWord is a prefix of this word (1-indexed).
If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
A prefix of a string S is any leading contiguous substring of S.
Input: sentence = "i love eating burger", searchWord = "burg"
Output: 4 

 */
public class Leet_190_01_TP {

	public static void main(String[] args) {
		Leet_190_01_TP obj = new Leet_190_01_TP();
		String sentence = "i am tired";
		String searchWord = "you";
		System.out.println(obj.isPrefixOfWord(sentence, searchWord));

	}

	 public int isPrefixOfWord(String sentence, String searchWord) {
		 String[] strArr = sentence.split(" ");
		 int i = 0;
		 boolean found = false;
		 for(i = 0; i < strArr.length; i++) {
			 if(strArr[i].startsWith(searchWord)) {
				 found = true;
				 break;
			 }
		 }
	 
		 return found ? ++i : -1;
	 }
}
