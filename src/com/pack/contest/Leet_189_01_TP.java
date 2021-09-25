package com.pack.contest;

/*
 Given two integer arrays startTime and endTime and given an integer queryTime.

The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].

Return the number of students doing their homework at time queryTime. More formally, return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.
 */
public class Leet_189_01_TP {

	public static void main(String[] args) {
		int[] a = new int[] {9,8,7,6,5,4,3,2,1};
		int[] b = new int[] {10,10,10,10,10,10,10,10,10};
		int query = 5;

		System.out.println(busyStudent(a, b, query));
	}
	
	 public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		 int count = 0;
		 for(int i = 0; i < startTime.length; i++) {
			 if( queryTime >=startTime[i] && queryTime <= endTime[i]) {
				 count++;
			 }
		 }
		 
		 return count;
	 }

}
