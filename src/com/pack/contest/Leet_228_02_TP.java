package com.pack.contest;

public class Leet_228_02_TP {

	public static void main(String[] args) {
		Leet_228_02_TP obj = new Leet_228_02_TP();
//		String s = "abbcccaa"; // 13
//		String s = "xy"; // 2
		String s = "zzzzz"; // 15
//		String s = "a";
		System.out.println(obj.countHomogenous(s));		

	}
	
	 public int countHomogenous(String s) {
		 int count = 1 ; // for first char
		 long result = 1;
		 for(int i = 1; i < s.length(); i++) {
			 if(s.charAt(i) == s.charAt(i-1)) {
				 count++;
			 }
			 else {
				 count = 1;
			 }
			 result = result + count;
		 }
		 // get module 10^7
		 double m = Math.pow(10, 9) + 7;
		 return (int) (result%m);
	 }
}
	

