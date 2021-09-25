package com.pack.contest;
/**
 * 
 * 
 * [[1,1],[0,0],[2,0]]
 * 	2.73205
 * @author LordOfAll
 *
 */
public class Leet_197_04_TP {

	public static void main(String[] args) {
		Leet_197_04_TP obj = new Leet_197_04_TP();
		
	}

	public double getMinDistSum(int[][] positions) {
		int xc = 0;
		int yc = 0;
		
		int size = positions.length;
		
		for(int i = 0; i < positions.length; i++) {
			xc = xc + positions[i][0];
			yc = yc + positions[i][1];
		}
		
		double cetroidX = xc/size;
		double centroidY = yc/size;
		
		double result = 0;
		for(int i = 0; i < positions.length; i++) {
			double dist = Math.sqrt(Math.pow((cetroidX - positions[i][0]), 2) + Math.pow((centroidY - positions[i][1]), 2));
			result = result + dist;
			
		}
		return result;
    }
}
