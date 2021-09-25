package com.pack.practice;

import java.util.Arrays;

/**
 * given an array of numbers arr [2,9,3,5,6]
 * find the number which is neares to k = 4
 * number can be 3 or 5
 * @author LordOfAll
 * 
 * WRONG
 *
 */
public class NearestNumber {

	public static void main(String[] args) {
		int[] arr = {2,9,3,5,6};
		int k = 4;
		NearestNumber obj = new NearestNumber();
		Arrays.sort(arr); // 2,3,5,6,9
		int result = obj.findNearest(arr, k, 0 , arr.length-1);
		System.out.println(result);
	}

	private int findNearest(int[] arr, int k, int left, int right) {
		if(left == right) {
			return arr[left];
		}
		
		int mid =left + (right-left)/2;
		
		int diffLeft = Math.abs(arr[left]-k) ;
		int diffRight = Math.abs(arr[right]-k) ;
		
		if(arr[mid] == k) return k;
		
		if(diffLeft < diffRight) {
			return findNearest(arr, k, left, mid);
		}
		else {
			return findNearest(arr, k, mid, right);
		}
	}

}
