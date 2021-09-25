package com.pack.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_204_01_TP {

	public static void main(String[] args) {
		Leet_204_01_TP obj = new Leet_204_01_TP();
		int[] arr = {1,2,4,4,4,4};
		int m = 1; int k = 3;
		
		System.out.println(obj.containsPattern(arr, m, k));

	}

	public boolean containsPattern(int[] arr, int m, int k) {
		boolean result = false;
		
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length-m; j++) {
//				if(arr[j] == )
			}
		}
        return result;
    }
}
	

