package com.pack.leet.may;

import java.util.HashMap;
import java.util.Map;

/*
 Given an array of integers arr.

We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

Let's define a and b as follows:

a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
Note that ^ denotes the bitwise-xor operation.

Return the number of triplets (i, j and k) Where a == b.

Input: arr = [2,3,1,6,7]
Output: 4
Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)

Input: arr = [1,1,1,1,1]
Output: 10

Input: arr = [2,3]
Output: 0
 */
public class Leet_02_Ccontest {

	static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		int[] arr = new int[] {1,1,1,1,1};
		System.out.println(countTriplets(arr));
	}
	
    public static int countTriplets(int[] arr) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>(); 
       // 0 <= i < j <= k < arr.length
        for(int i = 0; i < arr.length-1; i++) {
        	for (int j = i+1; j < arr.length; j++) {
        		for (int k = j; k < arr.length; k++ ) {
        			int a = calculateXOR(arr, i, j-1);
        			int b = calculateXOR(arr, j, k);
        			if(a == b) count++;
        		}
        	}
        }
        return count;
    	
    }
    
    public static int calculateXOR(int[] arr, int i, int j) {
    	if(map.containsKey(i+"_"+j)) 
    		return map.get(i+"_"+j);
    	int result = arr[i];
    	for(int x = i+1; x <= j; x++) {
    		result = result ^ arr[x];
    	}
    	
    	map.put(i+"_"+j, result);
    	return result;
    }

}


