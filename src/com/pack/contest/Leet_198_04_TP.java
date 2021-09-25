package com.pack.contest;

import java.util.Arrays;

public class Leet_198_04_TP {

	public static void main(String[] args) {
		Leet_198_04_TP obj = new Leet_198_04_TP();
//		int[] arr = { 9, 12, 3, 7, 15 };
//		int target = 5; // 2
//		System.out.println(obj.closestToTarget(arr, target));
		
//		int[] arr = { 1000000,1000000,1000000 };
//		int target = 1; // 999999
//		System.out.println(obj.closestToTarget(arr, target));
		
//		int[] arr = { 1,2,4,8,16};
//		int target = 0; // 0
//		System.out.println(obj.closestToTarget(arr, target));
		
		int[] arr = { 5,89,79,44,45,79};
		int target = 965; // 876
		System.out.println(obj.closestToTarget(arr, target));
		

	}

	public int closestToTarget(int[] arr, int target) {
		Arrays.sort(arr);
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				System.out.println(i + " " + j + " " + misFunc(arr, i, j) + " " + (target - misFunc(arr, i, j)) );
				result = Math.min(result, Math.abs(target - misFunc(arr, i, j) ));
			}
		}
		return result;
	}

	int misFunc(int[] arr, int l, int r) {
		if(r < l) return -1000000000;
		
		int ans = arr[l];
		
		for(int i = l+1; i <= r; i++) {
			ans = ans & arr[i];
		}
		
		return ans;
		
	}
}
