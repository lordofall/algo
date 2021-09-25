package com.pack.leet.june;
/*
Given an integer, write a function to determine if it is a power of two.
Input: 1
Output: true 
Explanation: 20 = 1

Input: 218
Output: false

Input: 0
Output: false

Input: -16
Output: false

Input: -2147483648
Output: false
*/
public class Leet_08_PowerOf2 {

	public static void main(String[] args) {
		Leet_08_PowerOf2 obj = new Leet_08_PowerOf2();
		int n = -16;
		System.out.println(obj.isPowerOfTwo(n));
	}
	
	// 
    public boolean isPowerOfTwo(int n) {
        int count =0;
        while(n>0) {
            if(n%2==1)
            count++;
            if(count>1)
            break;
            n = n/2;
        }
        return count==1;
    }
	// not working for -16
	public boolean isPowerOfTwo1(int n) {
		if(n == 0) return false;
		while(n > 1) {
			if(n%2 != 0) return false;
			n = n/2;
		}
        return true;
    }
	
	// not working for -2147483648
	public boolean isPowerOfTwo2(int n) {
        return n != 0 && ((n & (n - 1)) == 0);
    }
}
