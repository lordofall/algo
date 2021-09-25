package com.pack.contest;

import java.util.Arrays;

public class Leet_203_02_TP {

	public static void main(String[] args) {
		Leet_203_02_TP obj = new Leet_203_02_TP();
		int[] piles = {2,4,1,2,7,8}; // 9
//		int[] piles = {2,4,5}; // 4
//		int[] piles = {9,8,7,6,5,1,2,3,4}; // 18
		System.out.println(obj.maxCoins(piles));

	}
	// Accepted
	public int maxCoins(int[] piles) {
        int result = 0;
		Arrays.sort(piles);
		int arrlen = piles.length;
        for(int i = arrlen/3; i < arrlen; i=i+2) {
        	result += piles[i];
        }
		return result;
    }
}
