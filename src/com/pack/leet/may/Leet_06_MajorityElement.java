package com.pack.leet.may;

import java.util.HashMap;
import java.util.Map;

//Given an array of size n, find the majority element. 
//The majority element is the element that appears more than n/2 times.
//You may assume that the array is non-empty and the majority element always exist in the array.

public class Leet_06_MajorityElement {
	public static void main(String[] args) {
		/*
		 Input: [3,2,3]
		 Output: 3
		 */
		
		/*
		 Input: [2,2,1,1,1,2,2]
		 Output: 2
		 */
		int[] input = new int[] {2,2,1,1,1,2,2};
		System.out.println(majorityElement(input));
		
	}
	
	
	public static int majorityElement(int[] nums) {
		int n = nums.length/2;
		Map<Integer, Integer> map = new HashMap<>();
		for(int num: nums) {
            int val = map.getOrDefault(num, 0)+1;
            if(val > n) {
                return num;
            }    
			map.put(num, val);
		}
		return 0;
    }
}
