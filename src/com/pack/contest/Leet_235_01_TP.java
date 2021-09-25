package com.pack.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * @author LordOfAll
 *
 */
public class Leet_235_01_TP {

	public static void main(String[] args) {
		Leet_235_01_TP obj = new Leet_235_01_TP();

//		String s = "Hello how are you Contestant";
//		int k = 4;
		
		String s = "What is the solution to this problem"; int k = 4;

		System.out.println(obj.truncateSentence(s, k));

	}

	
	 public String truncateSentence(String s, int k) {
		 String[] sArr = s.split(" ");
		 StringBuffer strbuf = new StringBuffer();
		 for(int i = 0; i < k; i++) {
			 strbuf.append(sArr[i]);
			 strbuf.append(" ");
		 }
		 
	     return strbuf.toString().trim();   
	 }
	
}
