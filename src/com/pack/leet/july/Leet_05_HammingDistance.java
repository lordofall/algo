package com.pack.leet.july;

import java.util.Arrays;
/*
Hamming Distance
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
 */
public class Leet_05_HammingDistance {

	public static void main(String[] args) {
		Leet_05_HammingDistance obj = new Leet_05_HammingDistance();
		int a  = 3;
		int b = 1;
		System.out.println(a&b);
		System.out.println(obj.hammingDistance(5,10));

	}

	/*
	 * Brian Kernighan’s Algorithm
	 * Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit.
	 */
	public int hammingDistance(int x, int y) {
		int xor = x ^ y;
//		System.out.println(Integer.toBinaryString(x));
//		System.out.println(Integer.toBinaryString(y));
//		System.out.println(Integer.toBinaryString(xor));
		
        return countSetBits(xor);
    }
	
	private int countSetBits(int n) { 
        int count = 0;
//        System.out.println(n+" "+Integer.toBinaryString(n));
        while (n > 0) { 
            n = n & (n - 1); 
//            System.out.println(n+ " "+Integer.toBinaryString(n));
            count++; 
        } 
        return count; 
    } 
}
