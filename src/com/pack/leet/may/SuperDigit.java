package com.pack.leet.may;

import java.io.IOException;
import java.util.Scanner;

public class SuperDigit {

	 // Complete the superDigit function below.
    static int superDigit(String n, int k) {
    	
    	return sum(String.valueOf(k*sum(n)));
    }
    
    private static int sum(String str) {
    	if(str.length() == 1) {
    		return Integer.parseInt(str);
    	}
    	int sum = 0;
    	for(int i = 0; i < str.length(); i++) {
    		sum = sum + Character.getNumericValue(str.charAt(i));
    	}
    	
    	return sum(String.valueOf(sum));
    }


/*    private static int sum(char[] n) {
		if(n.length == 1) {
			return  Character.getNumericValue(n[0]);
		}
		
		int sum = 0;
    	for(int i = 0; i < n.length; i++) {
    		sum = sum + Character.getNumericValue(n[i]);
    	}
    	
		return sum(String.valueOf(sum).toCharArray());
	}*/


	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * input would be 148 3
	 * so get the super digit of 148148138
	 * @param args
	 * @throws IOException
	 */
    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        System.out.println(result);


        scanner.close();
//    	System.out.println(sum("10021981"));
    }
    
}
