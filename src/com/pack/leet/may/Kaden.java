package com.pack.leet.may;

public class Kaden {

	public static void main(String[] args) {
		int[] input = new int[] {2, 1, 2, 1, 3};
		System.out.println(minkaden(input));
	}
	
	
	 public static int kaden(int[] A) {
			int splitMax = 0;
			int globalMax= A[0];

			for(int x : A) {
				splitMax = Math.max(splitMax + x, x);
				globalMax = Math.max(splitMax, globalMax);
			}
			return globalMax;
	}

	/**
	 * sum of subarray with maximum value
	 * @param input
	 * @return
	 */
	private static int maxkaden(int[] input) {
		int max_so_far = 0;
		int max_ending_here = 0;
		
		for(int x: input) {
			
			if(max_ending_here + x < 0)
				max_ending_here = 0;
			else {
				max_ending_here = max_ending_here + x;
				
				if(max_ending_here > max_so_far) 
					max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}
	
	
	/**
	 * sum of subarray with minium value
	 * @param input
	 * @return
	 */
	private static int minkaden(int[] input) {
		int min_so_far = 0;
		int min_ending_here = 0;
		int smallest = input[0];
		
		for(int x: input) {
			
			if(min_ending_here + x > 0)
				min_ending_here = 0;
			else {
				min_ending_here = min_ending_here + x;
				
				if(min_ending_here < min_so_far) 
					min_so_far = min_ending_here;
			}
			
			if(smallest > x) {
				smallest = x;
			}
		}
		
		if(min_so_far == 0) min_so_far = smallest;
		
		return min_so_far;
	}
	
}
