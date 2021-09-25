package com.pack.contest;

public class Leet_201_01_TP {

	public static void main(String[] args) {
		Leet_201_01_TP obj = new Leet_201_01_TP();
//		 String s = "s";
//		String s = "leEeetcode";
//		 String s = "qFxXfQo";
//		String s = "qQo";
		String s = "abBAcC";
		System.out.println(obj.makeGood(s));
	}

	public String makeGood(String s) {
		String result = "";
		boolean check = true;
		while (check) {
			result = "";
			int len = s.length();
			if(len <= 1) {
				return s;
			}
			for (int i = 0; i < len; i++) {
				if (i+1 < len) {
					if(s.charAt(i) + 32 != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 1) + 32) {
						result = result + s.charAt(i);
					}
					else {
						i++;
					}
				}
				else if(i+1 == len) {
					result = result + s.charAt(i);
				}
			}
			if(s.length() == result.length())
				check = false;
			s = result;
			
		}
		return result;
	}
}
