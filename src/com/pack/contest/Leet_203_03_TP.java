package com.pack.contest;

import java.util.Arrays;

public class Leet_203_03_TP {

	public static void main(String[] args) {
		Leet_203_03_TP obj = new Leet_203_03_TP();
//		int[] arr = {3,5,1,2,4};
//		int m = 1; // 4
//		int[] arr = {3,5,1,2,4};
//		int m = 2; // -1
//		int[] arr = {1};
//		int m = 1; // 1
		int[] arr = {2,1};
		int m = 2; // 2
		System.out.println(obj.findLatestStep(arr, m));

	}
	
	public int findLatestStep(int[] arr, int m) {
		if(arr.length == 1 && m == 1) return 1;
		int[] binStr = new int[arr.length];
		Arrays.fill(binStr, 0);
		int i = 0;
		for(i = 0; i < arr.length; i++) {
			binStr[arr[i]-1] = 1;
			if(!checkIfAnyGroupOfMExists(binStr, m)) {
				break;
			}
		}
		return i-1;
    }

	private boolean checkIfAnyGroupOfMExists(int[] binStr, int m) {
		int count = 0;
		for(int i = 0; i < binStr.length; i++) {
			if(binStr[i] == 1) {
				count++;
				if(count == m) {
					return true;
				}
			}
			else {
				count = 0;
			}
		}
		return false;
	}
}
