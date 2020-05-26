package com.pack.leet.may;

import java.util.logging.Logger;

public class Leet_04_Complement {

	private static final Logger logger = Logger.getLogger(Leet_04_Complement.class.getSimpleName());
	
	private static final String abc = "ABC";
	
	public static void main(String[] args) {
		System.out.println(findComplement2(10));
	}
	
	public static int findComplement2(int num) {
		
		boolean flag = (num == 0);
		logger.info(""+abc);
		int div = num;
		int result = 0;
		
		int count = 0;
		while(div > 0) {
			int rem = div%2  ;
			div = div / 2;
			if(rem == 0) { 
				result = (int) (result + Math.pow(2, count));
			}
			count++;		
		}
		
        return result;
    }

	public static int findComplement(int num) {
		int div = num;
		String bin = "";
		int result = 0;
		while(div > 0) {
			bin = div%2+bin  ;
			div = div / 2;
		}
		for(int i = 0; i < bin.length(); i++) {
			String s = bin.substring(i, i+1);
			if(s.equals("0")) {
				result = (int) (result + 1* Math.pow(2, bin.length()-1-i));
			}
			else {
				result = result + 0;
			}
		}
        return result;
    }
}
