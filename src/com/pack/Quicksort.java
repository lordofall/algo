package com.pack;

import java.util.Arrays;

public class Quicksort {

	public static void main(String[] args) {
		int[] arr = {8, 9, 1 , 0, 3, 5};
		
		
		quicksort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));

	}

	private static void quicksort(int[] arr, int lo, int hi) {
		if(lo < hi) { // there are at least two elements if lo < hi.
			int p = partition(arr, lo, hi);
			quicksort(arr, lo, p-1);
			quicksort(arr, p+1, hi);
		}
	}

	/**
	 * get the last element at the right position, lets say at index p and return p.
	 * last element of array will be at right position if all elements left to it are smaller and 
	 * all elements right to it are greater
	 * @param arr
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[lo];
		int i = lo+1;
		int j = hi;
		
		while(i < j) {
			
			while (arr[i] < pivot) i++;
			while (arr[j] >= pivot) j--;
			
			if(i < j) {
				swap(arr, i, j);
			}
		}
		
		swap(arr, lo, j);
		
		return j;
	}
	
	/**
	 * swap the element at index i and j in the array
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
