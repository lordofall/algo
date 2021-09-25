package com.pack.leet.may;

import java.util.Arrays;

/*
Given a non negative integer number num. 
For every numbers i in the range 0 <= i <= num calculate the 
number of 1's in their binary representation and 
return them as an array.

Input: 2
Output: [0,1,1]

Input: 5
Output: [0,1,1,2,1,2]

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class Leet_29_CountingBits {

	public static void main(String[] args) {
		Leet_29_CountingBits obj = new Leet_29_CountingBits();
		
		System.out.println(Arrays.toString(obj.countBits(10)));
	}
	
	
	public int[] countBits(int num) {
		int[] result = new int[num+1];
		
		int p = 1; //p tracks the index for number x
	    int pow = 1;
	    for(int i=1; i<=num; i++){
	        if(i==pow){// for 1, 2, 4, 8 , 16 .. number of 1 in the binary representation is always 1.
	            result[i] = 1;
	            pow <<= 1; // pow = pow << 1 ; it doubles the pow
	            p = 1;
	        }else{
	            result[i] = result[p]+1;
	            p++;
	        }
	 
	    }
	    return result;
		
    }
}
