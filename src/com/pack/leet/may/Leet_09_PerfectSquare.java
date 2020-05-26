package com.pack.leet.may;

/*
 Given a positive integer num, write a function which returns True if num is a perfect square else False.
 
 Input: 16
Output: true

Input: 14
Output: false
 */
public class Leet_09_PerfectSquare {

	public static void main(String[] args) {
		// 2147483647
		System.out.println(isPerfectSquare2(808201));
	}

	 static boolean isPerfectSquare(int num) {
		 return isPerfectSquare(1, num, num);
	 } 
	
	private static boolean isPerfectSquare(int start, int end, int target) {
		if(start == end) { // base case
			if(start*start == target ) {
				return true;
			}
			else {
				return false;
			}
		}
		
		int mid = start + (end -start)/2; // get the mid element
		
		if((long)mid*mid < target ) // one of multiplicand is cast to long so that product of two integer doesnt overflow the Integer.Max
			return isPerfectSquare(mid+1, end, target);
		else 
			return isPerfectSquare(start, mid, target);
		
	}

	/**
	 * it will work, but will get time out error e.g num = 2147483647
	 * @param num
	 * @return
	 */
	static boolean isPerfectSquare2(int num) {
		 for(int i = 1; i <= num; i++) {
			 if(i*i == num) return true;
			 if(i*i > num) return false;
		 }
		 return false;
	 }
	 
	 
	 
}
