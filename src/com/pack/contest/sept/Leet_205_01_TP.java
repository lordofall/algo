package com.pack.contest.sept;

public class Leet_205_01_TP {

	public static void main(String[] args) {
		Leet_205_01_TP obj = new Leet_205_01_TP();
//		String s = "ubv?w";
//		String s = "?zs";
//		String s = "j?qg??b";
//		String s = "??yw?ipkj?";
		String s = "?peleuv?a????zel";
		System.out.println(obj.modifyString(s));

	}

	public String modifyString(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '?') {
				int prev = i-1;
				int next = i+1;
				while(next < s.length() && s.charAt(next) == '?') {
					next +=1;
				}
				s = s.replaceFirst("\\?", String.valueOf(getNextChar(s,prev,next)));
			}
		}
		return s;
	}

	private char getNextChar(String s, int i, int j) {
		char c = 'a';
		if(i >= 0 && j < s.length()) {
			int max = Math.max(s.charAt(i), s.charAt(j));
			if(max + 1 <= 'z') {
				return (char) (max+1);
			}
			else {
				if(s.charAt(i) == 'a') {
					return (char) (s.charAt(i) +1);
				}
				else {
					return 'a';
				}
			}
		}
		
		// first element
		else if(i == -1 && j < s.length()) {
			return (char) (s.charAt(j)+1 < 'z' ? s.charAt(j)+1 : 'a');
		}
		
		// last element
		else if(j == s.length() && i >= 0) {
			return (char) (s.charAt(i)+1 < 'z' ? s.charAt(i)+1 : 'a');
		}
		return c;
	}
}
