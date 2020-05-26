package com.pack.leet.may;

import java.util.HashMap;
import java.util.Map;

public class Leet_03_Ransom {

	public static void main(String[] args) {
		System.out.println(canConstruct2("aa", "aba"));

	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		boolean found = true;
		Map<Character, Integer> ransomMap = new HashMap<>();
		Map<Character, Integer> magazineMap = new HashMap<>();
		
		for(int i = 0; i < ransomNote.length(); i++) {
			ransomMap.put(ransomNote.charAt(i), ransomMap.getOrDefault(ransomNote.charAt(i), 0)+1);
		}
		
		for(int i = 0; i < magazine.length(); i++) {
			magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0)+1);
		}
		
		for(Character c: ransomMap.keySet()) {
			if(ransomMap.get(c) > magazineMap.getOrDefault(c, 0)) {
				found = false;
				break;
			}
		}
		
        return found;
    }

	
	
	
	
	public static boolean canConstruct2(String ransomNote, String magazine) {
		boolean found = true;
		int[] ransomArray = new int[26];
		int[] magazineArray = new int[26];
		
		for(int i = 0; i < ransomNote.length(); i++) {
			ransomArray[ransomNote.charAt(i)-'a'] = ransomArray[ransomNote.charAt(i)-'a']+1;
		}
		
		for(int i = 0; i < magazine.length(); i++) {
			magazineArray[magazine.charAt(i)-'a'] = magazineArray[magazine.charAt(i)-'a']+1;
		}
		
		for(int i = 0; i < 26; i++) {
			if(ransomArray[i] > magazineArray[i]) {
				found = false;
				break;
			}
				
		}
        return found;
    }
}
