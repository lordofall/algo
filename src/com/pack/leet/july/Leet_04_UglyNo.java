package com.pack.leet.july;

import java.util.Arrays;

public class Leet_04_UglyNo {

	public static void main(String[] args) {
		Leet_04_UglyNo obj = new Leet_04_UglyNo();
		System.out.println(obj.nthUglyNumber(11));

	}

	
	public int nthUglyNumber(int n) {
		int[] arr = new int[n];
		int idx2 = 0, idx3 = 0, idx5 = 0;
		arr[0] = 1;

		for(int i = 1; i < n; i++) {
			int next2 = arr[idx2]*2;
			int next3 = arr[idx3]*3;
			int next5 = arr[idx5]*5;
			arr[i] = Math.min(Math.min(next2, next3), next5);
			
			if(arr[i] == next2) idx2++;
			if(arr[i] == next3) idx3++;
			if(arr[i] == next5) idx5++;
			
		}
        return arr[n-1];
    }
}
