package com.pack.leet.may;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */
public class Leet_10_TownJudge {

	public static void main(String[] args) {
		/*
		 Input: N = 2, trust = [[1,2]]
		 Output: 2
		 
		 Input: N = 3, trust = [[1,3],[2,3]]
		 Output: 3
		 
		 Input: N = 3, trust = [[1,2],[2,3]]
		 Output: -1
		 */
		
		System.out.println(findJudge(3, new int[][] {new int[] {1,2} }));

	}
	
	static int findJudge(int N, int[][] trust) {
		
        if(trust.length == 0) return 1;
        
        int[] arr = new int[1001];
		for(int i = 0; i < 1001; i++) arr[i] = 0;
		
		for(int i = 0; i < trust.length; i++) {
			if (arr[trust[i][0]] >= 0) arr[trust[i][0]] = -1; // was judge now nobody
			if(arr[trust[i][1]] != -1 ) arr[trust[i][1]] = arr[trust[i][1]] + trust[i][1]; 
		}
		List<Integer> probableJudge = new ArrayList<>();
		for(int i = 1; i < 1001; i++) {
            if(trust.length == 1 && arr[i] == i) return i;
			if(arr[i] > i) {
				probableJudge.add(i);
			}
        }
		
		if(probableJudge.size() == 1) 
			return probableJudge.get(0);
		return -1;
	}
}
