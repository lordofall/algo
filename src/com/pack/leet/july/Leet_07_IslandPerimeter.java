package com.pack.leet.july;

public class Leet_07_IslandPerimeter {

	public static void main(String[] args) {
		Leet_07_IslandPerimeter obj = new Leet_07_IslandPerimeter();
		int[][] grid = {{0,1,0,0},
				{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(obj.islandPerimeter(grid));

	}

	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int rows = grid.length+2;
		int cols = grid[0].length+2;
		
		int[][] dp = new int[rows][cols];
 		
		// add water all around
		for(int i = 0; i < rows; i++) {
			dp[i][0] = 0;
			dp[i][cols-1] = 0;
		}
		
		for(int j = 0; j < cols; j++) {
			dp[0][j] = 0;
			dp[rows-1][j] = 0;
		}
		
		// copy grid in dp
		for(int i = 0; i < rows-2; i++) {
			for(int j = 0; j < cols-2; j++) {
				dp[i+1][j+1] = grid[i][j];
			}
		}
		
		for(int i = 1; i < rows-1; i++) {
			for(int j = 1; j < cols-1; j++) {
				if(dp[i][j] == 1) {
					if(dp[i-1][j] == 0) perimeter+=1;
					if(dp[i+1][j] == 0) perimeter+=1;
					if(dp[i][j-1] == 0) perimeter+=1;
					if(dp[i][j+1] == 0) perimeter+=1;
				}
			}
		}
		return perimeter;
	}

}
