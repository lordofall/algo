package com.pack.leet.june;

import java.util.Arrays;

/*
Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
*/
public class Leet_04_stringReverse {

	public static void main(String[] args) {
		Leet_04_stringReverse obj = new Leet_04_stringReverse();
		char[] s = new char[] {'h','e','l','l','o', 'x'};
		obj.reverseString(s);
		System.out.println(s);
	}
	// ACCEPTED
	public void reverseString(char[] s) {
		for(int i = 0; i < s.length/2; i++) {
			char tmp = s[i];
			s[i] = s[s.length-i-1];
			s[s.length-i-1] = tmp;
		}
    }
	
	
	/*public void reverseString2(Character[] s) {
		Arrays.sort(s, new Comparable<? super Character>() {
			@Override
			public int compareTo(T o) {
				return -1;
			}
			
		}); 
    }*/
}
