package com.pack.leet.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Prison Cells After N Days
There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Ex2:
[1,1,0,1,1,0,1,1]
6

Ex3:
[1,0,0,1,0,0,1,0]
1000000000
output: [0,0,1,1,1,1,1,0]
 */
public class Leet_03_PrisonCell {

	public static void main(String[] args) {
		Leet_03_PrisonCell obj = new Leet_03_PrisonCell();
		int[] cells = {1,0,0,1,0,0,1,0};
		int N = 1000000000;
		int[] result = obj.prisonAfterNDays(cells, N);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] prisonAfterNDays(int[] cells, int N) {
		List<int[]> resultList = new ArrayList<>();
		resultList.add(null); // first element is null
		int[] original = new int[8];
		int[] result = new int[cells.length];
		int i = 0;
		for(i = 1; i <= N; i++) {
			
			for(int j = 1; j < cells.length-1; j++) {
				if(cells[j-1] == cells[j+1])
					result[j] = 1;
				else
					result[j] = 0;
			}
			result[0] = 0;
			result[cells.length-1] = 0;
			System.arraycopy(result, 0, cells, 0, 8);
			resultList.add(cells.clone());
			if(i > 1 && Arrays.equals(cells, original)) {
				break;
			}
			
			if(i == 1)
				original = cells.clone();
		}
		int rem = N-1; //last element
		if(i < N)
			rem = N % (i-1);
		return resultList.get(rem+1);
    }
	
	// bruteforce, works for smaller N. But time limit exceeded for
	// [1,0,0,1,0,0,1,0]
	// 1000000000
	public int[] prisonAfterNDays2(int[] cells, int N) {
		int[] result = new int[cells.length];
		for(int i = 0; i < N; i++) {
			
			for(int j = 1; j < cells.length-1; j++) {
				if(cells[j-1] == cells[j+1])
					result[j] = 1;
				else
					result[j] = 0;
			}
			result[0] = 0;
			result[cells.length-1] = 0;
			System.arraycopy(result, 0, cells, 0, 8);
		}
		return cells;
    }
}
