package com.pack.contest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/*
The k Strongest Values in an Array
Given an array of integers arr and an integer k.

A value arr[i] is said to be stronger than a value arr[j] if |arr[i] - m| > |arr[j] - m| 
where m is the median of the array.
If |arr[i] - m| == |arr[j] - m|, then arr[i] is said to be stronger than arr[j] if arr[i] > arr[j].

Return a list of the strongest k values in the array. return the answer in any arbitrary order.

Median is the middle value in an ordered integer list. More formally, 
if the length of the list is n, the median is the element in position ((n - 1) / 2) in the sorted list (0-indexed).

For arr = [6, -3, 7, 2, 11], n = 5 and the median is obtained by sorting the array arr = [-3, 2, 6, 7, 11] and 
the median is arr[m] where m = ((5 - 1) / 2) = 2. The median is 6.

 
Input: arr = [1,2,3,4,5], k = 2
Output: [5,1]
Explanation: Median is 3, the elements of the array sorted by the strongest are [5,1,4,2,3]. 
The strongest 2 elements are [5, 1]. [1, 5] is also accepted answer.
Please note that although |5 - 3| == |1 - 3| but 5 is stronger than 1 because 5 > 1.

Input: arr = [1,1,3,5,5], k = 2
Output: [5,5]

Input: arr = [6,7,11,7,6,8], k = 5
Output: [11,8,6,6,7]

Input: arr = [6,-3,7,2,11], k = 3
Output: [-3,11,2]

Input: arr = [-7,22,17,3], k = 2
Output: [22,17]
 */
public class Leet_192_02_KStrongest {

	public static void main(String[] args) {
		
		Integer[] arr1 = {2,3,4,5, 1};
		
		Arrays.sort(arr1, (a, b)-> b-a);
		
		System.out.println(Arrays.toString(arr1)); 
		
		/*Leet_192_02_KStrongest obj = new Leet_192_02_KStrongest();
		int[] arr = new int[] {6,-3,7,2,11};
		int k = 3;
		System.out.println(Arrays.toString(obj.getStrongest(arr, k)));*/
 	}

	
	public int[] getStrongest(int[] arr, int k) {
		int[] result = new int[k];
		Arrays.sort(arr);
		int medianIndex = (arr.length-1)/2;
		int median = arr[medianIndex];
	    
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> 
	    	Math.abs(a-median) == Math.abs(b-median) ? b - a : Math.abs(b-median) - Math.abs(a-median)
	    );
	    
//	    maxHeap.addAll(Arrays.asList(arr));
	    for(int i = 0; i < arr.length; i++)
	    	maxHeap.add(arr[i]);
	    
	    for (int i = 0; i < k; i++) 
	    	result[i] = maxHeap.remove();

		return result;
    }
}
