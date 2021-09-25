package com.pack.contest;

public class Leet_204_02_TP {

	public static void main(String[] args) {
		Leet_204_02_TP obj = new Leet_204_02_TP();
//		int[] nums = { 1, -2, -3, 4 }; // 4
//		int[] nums = { 0, 1,-2,-3,-4 }; // 3
//		int[] nums = { -1,-2,-3, 0, 1 }; // 2
//		int[] nums = { -1,2 }; // 1
		int[] nums = { 1,2,3,5,-6,4,0,10 }; // 4
		
		System.out.println(obj.getMaxLen(nums));

	}

	public int getMaxLen(int[] nums) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		int consecutiveNegatives = 0;

		if(nums[0] > 0) {
			maxSoFar = 1;
			maxEndingHere = 1;
		}
		else if(nums[0] < 0){
			consecutiveNegatives=+1;
		}
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] > 0) {
				consecutiveNegatives = 0;
				maxEndingHere += 1;
			}
			else if(nums[i] < 0) {
				if(nums[i-1] > 0) {
					consecutiveNegatives = 1;
//					maxEndingHere = 0;
				}
				if(nums[i-1] < 0) {
					consecutiveNegatives +=1;
					if(consecutiveNegatives%2 == 0) {
						maxEndingHere = maxEndingHere + 2;
					}
					else {
						maxEndingHere = 0;
					}
				}
			}
			else if(nums[i] == 0)
				maxEndingHere = 0;
			
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
			
		}
		return maxSoFar;
	}
	
	

}
