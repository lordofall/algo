package com.pack.contest;
/*
XOR Operation in an Array

Given an integer n and an integer start.

Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.

Return the bitwise XOR of all elements of nums.

Input: n = 5, start = 0
Output: 8
 */
public class Leet_194_01_XOR {

	public static void main(String[] args) {
		Leet_194_01_XOR obj = new Leet_194_01_XOR();
		System.out.println(obj.xorOperation(10, 5));
	}

	public int xorOperation(int n, int start) {
		int xor = start;
		for(int i = 1; i < n; i++) {
			xor = xor ^ (start+2*i);
		}
		return xor;
    }

}
