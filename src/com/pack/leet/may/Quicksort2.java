package com.pack.leet.may;

public class Quicksort2 {

	public static void main(String[] args) {
		int[] nums = new int[] {5,1,1,2,0,0};
		// 5,1,1,2,0,0
		// 5, 2, 3, 1
		for(int x: sortArray(nums)) {
			System.out.print(x + " ");
		}

	}

    static int[] sortArray(int[] nums) {
    	quickSort(nums, 0, nums.length-1);
    	return nums;
    }
    
    private static void quickSort(int[] nums, int start, int end) {
		if(start < end) {
			int p = partition(nums, start, end);
			quickSort(nums, start, p-1);
			quickSort(nums, p+1, end);
		}
	}

	static int partition(int[] nums, int start, int end) {
    	int pivot = start; // let the first index be pivot
    	int i = start+1;
    	int j = end;
    	while(i < j) {
    		while(nums[i] < nums[pivot] && i < end) i++;
    		while(nums[j] >= nums[pivot] && j > pivot+1) j--; 
    		if(i < j)
    			swap(nums, i, j);
    	}
    	
    	// when i and j crosses, swap the pivot with j
    	if(nums[pivot] > nums[j])
    		swap(nums, pivot, j);
    	
    	return j;
    	
    }

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}
}
