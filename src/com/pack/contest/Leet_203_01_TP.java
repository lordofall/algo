package com.pack.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_203_01_TP {

	public static void main(String[] args) {
		Leet_203_01_TP obj = new Leet_203_01_TP();
//		int n = 4;
//		int[] rounds  = {1,3,1,2}; // 1,2
		
//		int n = 2;
//		int[] rounds = {2,1,2,1,2,1,2,1,2}; // 2
		int n = 7;
		int[] rounds = {1,3,5,7}; // 1,2,3,4,5,6,7
		System.out.println(obj.mostVisited(n, rounds));

	}

	
public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> result = new ArrayList<Integer>();
        int[] tracks = new int[n]; // initially 0 times visited
        for(int i = 1; i < rounds.length; i++) {
        	// ith rounds starts from 
        	for(int j = rounds[i-1]; j <= rounds[i]; j++) {
        		tracks[j-1]++;
        	}
        }
        System.out.println(Arrays.toString(tracks));
        return result;	
    }

}
