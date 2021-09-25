package com.pack.contest;

/**
 * 5676. Minimum Changes To Make Alternating Binary String
 * 
 * @author LordOfAll
 *
 */
public class Leet_228_01_TP {

	public static void main(String[] args) {
		Leet_228_01_TP obj = new Leet_228_01_TP();
		String s = "0100"; // 1
//		String s = "10"; // 0
//		String s = "1111"; // 2
//		String s = "10010100"; // 3
		System.out.println(obj.minOperations(s));

	}

	public int minOperations(String s) {
		int result1 = 0; // when s starts with 0
		int result2 = 0; // when s starts with 1
		char c1 = '0';
		char c2 = '1';
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != c1) {
				result1++;
			}
			
			if(s.charAt(i) != c2) {
				result2++;
			}
			
			if(c1 == '0') c1 = '1'; else c1 = '0';
			if(c2 == '0') c2 = '1'; else c2 = '0';
		}
		return Math.min(result1, result2);
	}
}
