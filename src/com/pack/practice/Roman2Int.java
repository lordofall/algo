package com.pack.practice;

import java.util.HashMap;
import java.util.Map;

public class Roman2Int {
	Map<Character, Integer> map = null;
	public static void main(String[] args) {
		Roman2Int obj = new Roman2Int();
		String s = "III";
		System.out.println(obj.romanToInt(s));

	}
	
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int result = 0;
		int i = 0; 
		while(i < s.length()) {
			char c1 = s.charAt(i);
			if(i+1 < s.length()) {
				char c2 = s.charAt(i+1);
				if(map.get(c1) >= map.get(c2)) {
					result += map.get(c1);
					i++;
				}
				else {
					result += (map.get(c2)-map.get(c1));
					i = i+2;
				}
			}
			else {
				result = result + map.get(c1);
				i++;
			}
		}
		
		return result;
    }

}
