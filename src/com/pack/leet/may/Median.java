package com.pack.leet.may;
/*
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class Median {

	public static void main(String[] args) {

		int[] nums1 = new int[] {1, 2};
		int[] nums2 = new int[] {3, 4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	 static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        double result = 0D;
	        int[] merged = new int[nums1.length+nums2.length];
	        
	        int l = 0; int r = 0; int m = 0; 
	        while(l < nums1.length && r < nums2.length) {
	            if(nums1[l] < nums2[r])
	                merged[m++] = nums1[l++];
	            else
	                merged[m++] = nums2[r++];
	        }
	        
	        while(l < nums1.length)
	            merged[m++] = nums1[l++];
	        
	        while(r < nums2.length)
	            merged[m++] = nums2[r++];
	        
	        
	        if(merged.length%2 == 0) { // even
	            result = (merged[merged.length/2] + merged[(merged.length/2) -1])/2.0D;
	        }
	        else { // odd 
	            result = merged[merged.length/2];
	        }
	        
	        
	        return result;
	    }
}
