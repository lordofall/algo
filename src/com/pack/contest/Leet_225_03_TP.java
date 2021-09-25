package com.pack.contest;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1738. Find Kth Largest XOR Coordinate Value
 * You are given a 2D matrix of size m x n, consisting of non-negative integers. You are also given an integer k.
 * The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j] 
 * where 0 <= i <= a < m and 0 <= j <= b < n (0-indexed).
 * Find the kth largest value (1-indexed) of all the coordinates of matrix.
 * @author LordOfAll
 *
 * Note (a ^ b ^ a = b)
 * 
 * dp[i][j] = matrix[i][j] ^ dp[i-1][j] ^ dp[i][j-1] ^ dp[i-1][j-1] 
 * 
 * In the above problem, assume its simple addition instead of xor. Then
 * dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] 
 * 
 * notice the diagonal element.
 */
public class Leet_225_03_TP {

	public static void main(String[] args) {
		Leet_225_03_TP obj = new Leet_225_03_TP();
		int[][] matrix = {{5,2},{1,6}};
		int k = 4; // 0
//		int k = 3; // 4
//		int k = 2; // 5
//		int k = 1; // 7
		
//		int[][] matrix = {{10,9,5},{2,0,4},{1,0,9},{3,4,8}};
//		int k = 10; // 1
		
		System.out.println(obj.kthLargestValue(matrix, k));
	}


	public int kthLargestValue(int[][] matrix, int k) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] xorMat = new int[rows][cols];
		
		xorMat[0][0] = matrix[0][0];
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,d) ->  {
        	return d - a;	
        });
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				int xor = matrix[i][j];
				if(i-1>=0) {
					xor = xor ^ xorMat[i-1][j];
				}
				if(j-1 >=0) {
					xor = xor ^ xorMat[i][j-1];
				}
				if(i-1 >=0 && j-1 >=0) {
					xor =  (xor ^ xorMat[i-1][j-1]);
				}
				xorMat[i][j] = xor;
				maxHeap.add(xor);
			}
		}
		System.out.println(Arrays.deepToString(xorMat));
		System.out.println(maxHeap);
		
		for(int i = 0; i < k-1; i++) {
			maxHeap.remove();
		}
        return maxHeap.peek();
    }
}
	

