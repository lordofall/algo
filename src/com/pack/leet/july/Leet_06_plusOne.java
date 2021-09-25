package com.pack.leet.july;

import java.util.Arrays;

/*
Plus One
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Input: [1,2,3]
Output: [1,2,4]

Input: [4,3,2,1]
Output: [4,3,2,2]

[9]
[1,0]

[9,9]
[1,0,0]
 */
public class Leet_06_plusOne {

	public static void main(String[] args) {
		Leet_06_plusOne obj = new Leet_06_plusOne();
		int[] digits = {9,9};
		System.out.println(Arrays.toString(obj.plusOne(digits)));
	}
	
	 public int[] plusOne(int[] digits) {
	        int[] result;
	        int len = digits.length; 
	        if(digits[len-1] == 9) {
	            result = new int[len+1];
	            System.arraycopy(digits, 0, result, 0, len);
	            result[len-1] = 1;
	            result[len] = 0;
	        }
	        else {
	            digits[len-1] +=1;    
	            result = digits.clone();
	        }
	        
	        return result;
	    }

}
