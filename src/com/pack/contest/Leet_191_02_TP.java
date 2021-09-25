package com.pack.contest;

import java.util.Arrays;

/*
Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.
Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4 
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.

Input:
Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts =[1]
Output: 6 

Input:
Input: h = 50, w = 15, horizontalCuts = [37,40,41,30,27,10,31], verticalCuts =[2,1,9,5,4,12,6,13,11]
Output: 51




*/
public class Leet_191_02_TP {

	public static void main(String[] args) {
		Leet_191_02_TP obj = new Leet_191_02_TP();
		int h = 5; int w = 4; 
		int[] horizontalCuts = new int[] {3,1};
		int[] verticalCuts = new int[] {1};
		System.out.println(obj.maxArea(h, w, horizontalCuts, verticalCuts));
	}

	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		long[] hArr = new long[horizontalCuts.length+1];
		long[] vArr = new long[verticalCuts.length+1];
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		for(int i =0; i<= horizontalCuts.length; i++) {
			if(i ==0) hArr[0] = horizontalCuts[i];
			else if(i == horizontalCuts.length) hArr[i] = h-horizontalCuts[i-1];
			else hArr[i] = horizontalCuts[i]- horizontalCuts[i-1];
		}
		
		for(int i =0; i<= verticalCuts.length; i++) {
			if(i ==0) vArr[0] = verticalCuts[i];
			else if(i == verticalCuts.length) vArr[i] = w-verticalCuts[i-1];
			else vArr[i] = verticalCuts[i]- verticalCuts[i-1];
		}
		
		double m = Math.pow(10, 9) + 7;

		long maxHArr = hArr[0];
		long maxVArr = vArr[0];
		for(int i = 0; i < hArr.length; i++) {
			maxHArr = Math.max(maxHArr, hArr[i]);
		}
		for(int i = 0; i < vArr.length; i++) {
			maxVArr = Math.max(maxVArr, vArr[i]);
		}
		return (int) ((maxHArr*maxVArr)%m);
	}
}
