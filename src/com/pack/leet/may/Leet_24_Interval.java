package com.pack.leet.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.

 */
public class Leet_24_Interval {

	public static void main(String[] args) {
		int[][] A = new int[][] {
			new int[] {0,2}, new int[] {5,10} , new int[] {13,23}, new int[] {24,25}
		};
		
		int[][] B = new int[][] {
			new int[] {1,5}, new int[] {8,12} , new int[] {15,24}, new int[] {25,26}
		};
		
		int[][] result = new Leet_24_Interval().intervalIntersection(A, B);
		System.out.println(Arrays.toString(result));
	}

	 public int[][] intervalIntersection(int[][] A, int[][] B) {
		 int i = 0, j = 0;
		 List<int[]> list = new ArrayList<>();
		 while(i < A.length && j < B.length) {
			 int leftBoundary = Math.max(A[i][0], B[j][0]);
			 int rightBoundary = Math.min(A[i][1], B[j][1]);
			 
			 if(leftBoundary <= rightBoundary)
				 list.add(new int[] {leftBoundary, rightBoundary});
			 
			 if(A[i][1] < B[j][1])  
				 i++;
			 else 
				 j++ ;
		 }
		 
		 return list.toArray(new int[list.size()][]);
	 }
	
}
