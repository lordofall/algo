package com.pack;

import java.util.Arrays;

/**
 * permutation by backtracking
 * @author LordOfAll
 *
 */
public class Permutation {

	public static void main(String[] args) {
		String str= "abc";
		permute(str, 0, str.length()-1);
	}

	private static void permute(String str, int l, int r) {
		if(l == r)
			System.out.println(str);
		
		else {
			for(int i = l; i <=r; i++) {
				str = swap(str, l, i);
				permute(str, l+1, r);
				str = swap(str, l, i);
			}
		}
	}

	private static String swap(String str, int i, int j) {
		char[] strArr = str.toCharArray();
		char temp = strArr[i];
		strArr[i] = strArr[j];
		strArr[j] = temp;
		return String.valueOf(strArr);
	}
}
