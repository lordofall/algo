package com.pack.leet.july;
/*
 * Reverse Words in a String
 * Input: "the sky is blue"
Output: "blue is sky the"
 */
public class Leet_15_ReverseString {

	public static void main(String[] args) {
		Leet_15_ReverseString obj = new Leet_15_ReverseString();
		String s = "the sky is blue";
		System.out.println(obj.reverseWords(s));

	}
	
	public String reverseWords(String s) {
		s = s.trim();
        String[] strArr = s.split("\\s+");
        StringBuilder buffer = new StringBuilder();
        for(int i = strArr.length-1; i >=0; i--)
        	buffer.append(strArr[i]).append(" ");
        
        return buffer.toString().trim();
    }

}
