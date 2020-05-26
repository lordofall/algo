package com.pack.leet.may;

public class MergeSort2 {

	public static void main(String[] args) {

		int[] nums1 = new int[] {1, 2, 5,4};
		int[] nums2 = new int[] { 2, 3};
		
		int[] merged = merge(nums1, nums2);
		
		for(int x: merged) {
			System.out.print(x + " ");
		}
	}

	
	static int[] merge(int[] nums1, int[] nums2) {
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
        
        return merged;
        
	}
}
