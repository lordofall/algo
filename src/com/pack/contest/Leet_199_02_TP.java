package com.pack.contest;

public class Leet_199_02_TP {

	public static void main(String[] args) {
		Leet_199_02_TP obj = new Leet_199_02_TP();
		String target = "101";
		System.out.println(obj.minFlips(target));
	}

	public int minFlips(String target) {
		int result = 0;
		int index = 0;
		while(index < target.length() && target.charAt(index) == '0') {
			index++;
		}
		if(index < target.length()) {
			result++;
		}
		for(int i = index; i < target.length()-1; i++) {
			if(target.charAt(i) != target.charAt(i+1)) {
				result++;
			}
		}
		return result;
	}
}
