package com.pack.contest;

public class Leet_199_01_TP {

	public static void main(String[] args) {
		Leet_199_01_TP obj = new Leet_199_01_TP();
		String s = "aaiougrt";
		int[] indices = {4,0,2,6,7,3,1,5};
		System.out.println(obj.restoreString(s, indices));
	}

	public String restoreString(String s, int[] indices) {
		char[] chars = new char[s.length()];
		
		for(int i = 0; i < indices.length; i++) {
			chars[indices[i]] = s.charAt(i);
		}
		return String.copyValueOf(chars);
    }
}
