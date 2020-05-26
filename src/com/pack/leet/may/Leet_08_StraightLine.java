package com.pack.leet.may;
/*
 You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. 
 Check if these points make a straight line in the XY plane.
 */
public class Leet_08_StraightLine {

	public static void main(String[] args) {
		/*
		 Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
		 Output: false
		 */
		int[][] coordinates = new int[][] { new int[] {1,1}, new int[] {2,2}, new int[] {3,4}
		, new int[] {4,5}, new int[] {5,6}, new int[] {7,7}};
		
		System.out.println(checkStraightLine(coordinates));
	}
	
    public static boolean checkStraightLine(int[][] coordinates) {
    	int dx = coordinates[0][0] - coordinates[1][0];
    	int dy = coordinates[0][1] - coordinates[1][1];
    	
    	for(int i = 2; i < coordinates.length; i++) {
    		if((coordinates[i][0] - coordinates[i-1][0])*dy != 
    				(coordinates[i][1] - coordinates[i-1][1])*dx)
    			return false;
    	}
        return true;
    }
}
