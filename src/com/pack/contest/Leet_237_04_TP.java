package com.pack.contest;

import java.util.HashSet;
import java.util.Set;

/**
 * 5737. Find XOR Sum of All Pairs Bitwise AND
 * 
 * @author LordOfAll
 *
 */
public class Leet_237_04_TP {

	public static void main(String[] args) {
		Leet_237_04_TP obj = new Leet_237_04_TP();
		int[] arr1 = {1,2,3}, arr2 = {6,5}; // 0
//		int[] arr1 = {12}, arr2 = {4}; // 4
		System.out.println(obj.getXORSum(arr1, arr2));
	}


	public int getXORSum(int[] arr1, int[] arr2) {
		int result = 0;
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				int andresult = arr1[i] & arr2[j];
				if(set.contains(andresult)) {
					set.remove(andresult);
				}
				else {
					set.add(andresult);
				}
			}
		}
		
		for(int x: set) {
			result = result ^ x;
		}
		return result;  
    }
}
