package com.pack.contest;

import java.util.Arrays;

/**
 * 5686. Minimum Number of Operations to Move All Balls to Each Box
 * 
 * @author LordOfAll
 *
 */
public class Leet_229_02_TP {

	public static void main(String[] args) {
		Leet_229_02_TP obj = new Leet_229_02_TP();
//		String boxes = "110"; // [1, 1, 3]
		String boxes = "001011"; // [11,8,5,4,3,4]	

		System.out.println(Arrays.toString(obj.minOperations(boxes)));

	}

	public int[] minOperations(String boxes) {
		int lenght = boxes.length();
        int[] result = new int[lenght];
        for(int i = 0; i < lenght; i++) {
        	char c = boxes.charAt(i);
        	
        	if(c == '1') {
        		for(int j = 0; j < lenght; j++ ) {
        			if(i != j) {
        				result[j] = result[j] + Math.abs(i-j);
        			}
        		}
        	}
        }
        return result;
    }
}
