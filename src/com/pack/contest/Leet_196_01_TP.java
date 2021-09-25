package com.pack.contest;

import java.util.Arrays;

public class Leet_196_01_TP {

	public static void main(String[] args) {
		Leet_196_01_TP obj = new Leet_196_01_TP();
		int[] arr = { 5, 4, 1 };
		System.out.println(obj.canMakeArithmeticProgression(arr));
	}

	public boolean canMakeArithmeticProgression(int[] arr) {
		Arrays.sort(arr);
		int diff = arr[1] - arr[0];
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] != diff)
				return false;
		}
		return true;
	}
}
