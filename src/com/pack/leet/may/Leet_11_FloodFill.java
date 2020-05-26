package com.pack.leet.may;
/*
 An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. 
Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

image = [[0,0,0],[0,1,1]]
sr = 1, sc = 1, newColor = 1

 */
public class Leet_11_FloodFill {

	public static void main(String[] args) {
		int[][] image = new int[][] {new int[] {0, 0, 0},new int[] {0,1,1} };
		floodFill(image, 1, 1, 1);
		System.out.println(image);
	}

	static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int currentColor = image[sr][sc];
		floodFill(image, sr, sc, currentColor, newColor);
		return image;
    }

	private static void floodFill(int[][] image, int sr, int sc, int currentColor, int newColor) {
		int rows = image.length;
		int cols = image[0].length;

		// base condition
		if(currentColor == newColor) return;
		if(sr < 0 || sr >= rows || sc < 0 || sc >=cols) return;
		if(image[sr][sc] != currentColor) return;
		
		image[sr][sc] = newColor;
		
		floodFill(image, sr-1, sc, currentColor, newColor);
		floodFill(image, sr, sc-1, currentColor, newColor);
		floodFill(image, sr+1, sc, currentColor, newColor);
		floodFill(image, sr, sc+1, currentColor, newColor);
		
	}
}
