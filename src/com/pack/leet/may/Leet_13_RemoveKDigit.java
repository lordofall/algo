package com.pack.leet.may;
/*
Given a non-negative integer num represented as a string, 
remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be >= k.
The given num does not contain any leading zero.

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

Input: num = "112", k = 1
output: "11"

Input: num = "1111111", k = 3
output: 1111

Input: num = "178", k = 1
output: 17
 */
public class Leet_13_RemoveKDigit {

	public static void main(String[] args) {
		System.out.println(removeKdigits("1111111", 3));
	}
	
	static String removeKdigits(String num, int k) {
		if(k == 0) {
			if(num.length() > 0) {
				String strPattern = "^0+";
				String result = num.replaceAll(strPattern, ""); // remove leading zeroes
				return result.length() > 0 ? result: "0"; // if result is "", return 0
			}
			else return "0";
		}
		
		if(num.length() == k) return "0";
		
		StringBuilder str = new StringBuilder(num);
		
		for(int i = 0; i < num.length()-1; i++) {
			char first = num.charAt(i);
			char second = num.charAt(i+1);
			if(first > second){
				str.deleteCharAt(i);
				break;
			}
		}
		
		// if after the for loop, nothing is deleted, that is possible if all number are same or in increasing order
		// in that case remove the last one
		if(num.length() == str.length()) str.deleteCharAt(num.length()-1);
		
		return removeKdigits(str.toString(), k-1);
    }

}
