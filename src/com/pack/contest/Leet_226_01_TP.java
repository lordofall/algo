package com.pack.contest;

public class Leet_226_01_TP {

	public static void main(String[] args) {
		Leet_226_01_TP obj = new Leet_226_01_TP();
//		int lowLimit = 1, highLimit = 10; // 2
//		int lowLimit = 5, highLimit = 15; // 2
		int lowLimit = 4, highLimit = 7; // 2
		System.out.println(obj.countBalls(lowLimit, highLimit));
		

	}

	public int countBalls(int lowLimit, int highLimit) {
		int max = 0;
		int[] ballCounts = new int[highLimit+1];
		
		for(int i = lowLimit; i <= highLimit; i++) {
			int noOfBall = noOfBalls(i);
			ballCounts[noOfBall]++; 
			if(ballCounts[noOfBall] > max) {
				max = ballCounts[noOfBall];
			}
		}
		return max;
    }
	
	private int noOfBalls(int n) {
		String str = String.valueOf(n);
		int sum = 0;
		for(int i = 0; i < str.toCharArray().length; i++) {
			char c = str.charAt(i);
			sum = sum + Integer.parseInt(String.valueOf(c));
		}
		return sum;
	}
}
	

