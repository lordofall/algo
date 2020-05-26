package com.pack.leet.may;

import java.util.Arrays;

public class Mergesort {

	public static void main(String[] args) {
		System.out.println("merge sort");
		
		int[] arr = {10, 8, 2, 3, 5, 11, 0, 24};
		System.out.println(Arrays.toString(arr));
		mergesort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergesort(int[] arr, int l, int r) {
		//if(l == r) return ;
		if(l < r) {
			int mid = (l+r)/2;
			mergesort(arr, l, mid);
			mergesort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}

	/**
	 * 
	 * merge two arrays, first array is from l to mid And second is from mid+1 to r
	 * @param arr
	 * @param l
	 * @param mid
	 * @param r
	 */
	private static void merge(int[] arr, int l, int mid, int r) {
		// create two tmp arrays, put values from original to these
		// now merge and put the sorted array in the original list
		int n1 = mid-l+1;
		int n2 = r-mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i = 0; i < n1; i++) {
			L[i] = arr[l+i];
		}
		
		for(int j = 0; j < n2; j++) {
			R[j] = arr[mid+1+j];
		}
		
		
		int i = 0, j =0, k = l ;
		
		while(i < L.length && j < R.length) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++; k++;
			}
			else {
				arr[k] = R[j];
				j++; k++;
			}
		}
		
		while(i < L.length) {
			arr[k] = L[i];
			i++; k++;
		}
		
		while(j < R.length) {
			arr[k] = R[j];
			j++; k++;
		}
		
		
	}
	
	
}
