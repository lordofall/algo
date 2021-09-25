package com.pack.leet.june;

import java.util.Arrays;

/*
Suppose you have a random list of people standing in a queue. 
Each person is described by a pair of integers (h, k), where h is the height 
of the person and k is the number of people in front of this person 
who have a height greater than or equal to h. 
Write an algorithm to reconstruct the queue.

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Leet_06_ReconstructQueuebyHeight {

	public static void main(String[] args) {
		Leet_06_ReconstructQueuebyHeight obj = new Leet_06_ReconstructQueuebyHeight();
		int[][] people = {
			{7,0}, {4,4}, {7,1}, {5,0},
			 {6,1}, {5,2}
		};
		
		int[][] result = obj.reconstructQueue(people);
		System.out.println(Arrays.deepToString(result));
	}

	public int[][] reconstructQueue(int[][] people) {
		int rows = people.length;
		int[][] result = new int[rows][2];
		// sort people by k, number of people ahead of him
		Arrays.sort(people, (a,b) ->  {
			if(a[0] != b[0]) return b[0] - a[0];
			else return a[1] - b[1];
		});
		
		for(int i = 0; i < rows; i++) {
			int move = people[i][1];
			int j = i;
			while(i - move != 0) {
				swap(people ,j, j-1);
				move++; j--;
			}
		}
		return people;
	}

	private void swap(int[][] people, int i, int j) {
		int[] tmp = people[i];
		people[i] = people[j];
		people[j] = tmp;
	}
	
				
}
