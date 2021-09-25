package com.pack.contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet_226_02_TP {

	public static void main(String[] args) {
		Leet_226_02_TP obj = new Leet_226_02_TP();
		int[][] adjacentPairs = { { 2, 1 }, { 3, 4 }, { 3, 2 } };
		System.out.println(Arrays.toString(obj.restoreArray(adjacentPairs))); // [1,2,3,4]

	}

	public int[] restoreArray(int[][] adjacentPairs) {
		int[] result = new int[adjacentPairs.length+1];
		int[] visited = new int[adjacentPairs.length];
		
		// interate over adjacentPairs and find out which one is not visited twice
		result = getResult(visited, result, adjacentPairs);
		return result;
	}

	private int[] getResult(int[] visited, int[] result, int[][] adjacentPairs) {
		
		Set<Integer> uniqueVals = new HashSet<>();
		for(int i = 0; i < adjacentPairs.length; i++) {
			if(visited[i] != 1) {
				if(uniqueVals.contains(adjacentPairs[i][0])) {
					uniqueVals.remove(adjacentPairs[i][0]);
				}
				else {
					uniqueVals.add(adjacentPairs[i][0]);
				}
				
				if(uniqueVals.contains(adjacentPairs[i][1])) {
					uniqueVals.remove(adjacentPairs[i][1]);
				}
				else {
					uniqueVals.add(adjacentPairs[i][1]);
				}
			}
		}
		
		if(uniqueVals.size() == 2) {
			// we got the unique values
			// two possibility?
		}
		return null;
	}
}
