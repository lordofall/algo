package com.pack.leet.may;
/*
 Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 
 Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
 */
public class Leet_22_DP {

	public static void main(String[] args) {
		Leet_22_DP obj = new Leet_22_DP();
		int[][] matrix = new int[][] {
			new int[] {0,1,1,1},
			new int[] {1,1,1,1},
			new int[] {0,1,1,1}
		};
		
		System.out.println(obj.countSquares(matrix));

	}

	
	public int countSquares(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int count = 0;
		
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				if(matrix[i][j] != 0)
					matrix[i][j] = Math.min(Math.min(matrix[i-1][j-1] ,matrix[i][j-1]), matrix[i-1][j]) + 1;
			}
		}
		
		// calculate the sum of the array
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				count += matrix[i][j];
			}
		}
		
        return count;
    }
}
