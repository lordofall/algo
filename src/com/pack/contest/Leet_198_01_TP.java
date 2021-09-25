package com.pack.contest;

public class Leet_198_01_TP {

	public static void main(String[] args) {
		Leet_198_01_TP obj = new Leet_198_01_TP();
//		int numBottles = 15; 
//		int numExchange = 4; // output = 19
//		System.out.println(obj.numWaterBottles(numBottles, numExchange));
		// 17 , 3, 24
		int numBottles = 17; 
		int numExchange = 3; // output = 24
		System.out.println(obj.numWaterBottles(numBottles, numExchange));
		

	}

	public int numWaterBottles(int numBottles, int numExchange) {
		int count = 0;
		while(numBottles > 0) {
			int d = numBottles / numExchange;
			int r =  numBottles % numExchange;
			count += d * numExchange;
			numBottles = d + r;
			if(numBottles < numExchange) {
				count = count + numBottles;
				numBottles = 0;
			}
		}
        return count;
    }

}
