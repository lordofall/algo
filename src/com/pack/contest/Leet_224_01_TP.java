package com.pack.contest;

import java.util.HashMap;
import java.util.Map;

public class Leet_224_01_TP {

	public static void main(String[] args) {
		Leet_224_01_TP obj = new Leet_224_01_TP();
		
//		int[][] rectangles = {{5,8},{3,9},{5,12},{16,5}};
//		int[][] rectangles = {{2,3},{3,7},{4,3},{3,7}};
		int[][] rectangles = {{5,8},{3,9},{3,12}};
//		int[][] rectangles = {{5,8},{3,9},{5,12}, {16,5}}; // 3
//		int[][] rectangles = {{3,12},{3,9},{8,5}}; // 1
		// [[3,12],[3,9],[8,5]]
		System.out.println(obj.countGoodRectangles(rectangles));

	}

	/**
	 * ACCEPTED but bad solution
	 * @param rectangles
	 * @return
	 */
	public int countGoodRectangles(int[][] rectangles) {
		int rows = rectangles.length;
		int squares[] = new int[rows];
		for(int i=0; i < rows; i++) {
			squares[i] = Math.min(rectangles[i][0],rectangles[i][1] );
		}
        int max = 0;
        int squareLength = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < rows; i++) {
        	int val = map.getOrDefault(squares[i], 0);
        	val++; // count is incremented by 1
        	map.put(squares[i], val);
        }
        
        for(Integer key: map.keySet()) {
        	if(key > squareLength) {
        		max = map.get(key);
        		squareLength = key;
        	}
        }
        return max;
    }
	
}
	

