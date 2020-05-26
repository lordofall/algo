package com.pack.leet.may;
/*
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)

Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3
*/
public class Leet_15_Kaden {

	public static void main(String[] args) {
		int[] input = new int[] {5, -6, 5};
		System.out.println(maxSubarraySumCircular(input));
	}
	

	 public static int maxSubarraySumCircular2(int[] A) {
			int splitMax = 0;
			int globalMax= A[0];

			for(int x : A) {
				splitMax = Math.max(splitMax + x, x);
				globalMax = Math.max(splitMax, globalMax);
			}

			return globalMax;
		}
	
	
	/**
	 * sum of subarray with minium value
	 * @param input
	 * @return
	 */
	 public static int maxSubarraySumCircular(int[] A) {
			int total_sum =0;
			int max_ending_at = 0;
			int min_ending_at =0;
			int largest= A[0];
			int smallest = A[0];

			for(int x : A) {
				total_sum += x;
				max_ending_at = Math.max(max_ending_at + x, x);
				largest = Math.max(max_ending_at, largest);
				min_ending_at = Math.min(min_ending_at + x, x);
				smallest = Math.min(min_ending_at, smallest);
			}

			if(largest>0) {
				return Math.max(largest, total_sum-smallest);
			}
			else {
				return largest;
			}
		}
	
}
