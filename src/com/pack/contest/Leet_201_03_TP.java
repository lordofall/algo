package com.pack.contest;

public class Leet_201_03_TP {

	public static void main(String[] args) {
		Leet_201_03_TP obj = new Leet_201_03_TP();
//		int[] nums = {1,1,1,1,1}; 
//		int target = 2; // utput = 2;
//		int[] nums = {-1,3,5,1,4,2,-9};
//		int target = 6;
		int[] nums = {-2,6,6,3,5,4,1,2,8};
		int target = 10; // output = 3
		System.out.println(obj.maxNonOverlapping(nums, target));
	}

	
	 public int maxNonOverlapping(int[] nums, int target) {
	     int i = 0;
	     int count = 0;
	     int currentSum = 0;
	     int start = 0;
		 while(i < nums.length) {
			 currentSum += nums[i];
			 if(currentSum == target) {
				 count++;
				 currentSum = 0;
				 start = i+1;
				 i++;
			 }
			 else if(currentSum > target) {
				 currentSum = 0;
				 i = start +1;
				 start = i;
			 }
			 else {
				 i++;
			 }
			 
		 }
		 return count;
	 }
}
