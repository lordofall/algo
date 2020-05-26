package com.pack.leet.may;

import java.io.IOException;

public class Leet_01_BST {
	public static int firstBadVersion1(int n) {
		int result = 1; // assume first version itself is wrong
		for (int i = 1; i <= n; i++) {
			if (isBadVersion(i)) {
				return i;
			}
		}
		return result;
	}

	public static int firstBadVersion(int n) {
		return binary(1, n);
	}
	// 0 0 0 1 1 1 1 1 1
	
	public static int binary(int start, int end) {
		if(start == end) {
			return start;
		}
		
		int mid = start + (end-start)/2;
		
		if(isBadVersion(mid)) {
			return binary(start, mid);
		}
		else {
			return binary(mid+1, end);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = 3;
		int k = 3;
		n = 2;
		k = 1;
		System.out.println("160 -29 result" + firstBadVersion(n));

	}

	static int k = 0;
	static int count = 0;

	static boolean isBadVersion(int m) {
		count++;
		// System.out.println("isBoolean called "+ count +" times");
		return m >= k;
	}
}
