package com.pack.leet.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
Each person may dislike some other people, and they should not go into the same group. 
Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way.
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false

N=10
dislikes =[[4,7],[4,8],[2,8],[8,9],[1,6],[5,8],[1,2],[6,7],[3,10],[8,10],[1,5],[7,10],[1,10],[3,5],[3,6],[1,4],[3,9],[2,3],[1,9],[7,9],[2,7],[6,8],[5,7],[3,4]]
output: true


*/
public class Leet_28_ArrBiPartisan {
	
	private int[] visited;
	private Map<Integer, List<Integer>> graph;
	public static void main(String[] args) {
		Leet_28_ArrBiPartisan obj = new Leet_28_ArrBiPartisan();
		int N = 5;
		int[][] dislikes = new int[][] {
			new int[] {1,2}, new int[] {2,3}, new int[] {3, 4}, new int[] {4, 5}, new int[] {1, 5},
		};
		System.out.println(obj.possibleBipartition(N, dislikes));
	}
	
	 public boolean possibleBipartition(int N, int[][] dislikes) {
	        if(N == 0 || dislikes.length == 0) return true;
	        graph = new HashMap<>();
	        for(int[] dislike : dislikes){
	            List<Integer> temp = graph.containsKey(dislike[0]) ? graph.get(dislike[0]): new ArrayList<>();
	            temp.add(dislike[1]);
	            graph.put(dislike[0], temp);
	            temp = graph.containsKey(dislike[1]) ? graph.get(dislike[1]): new ArrayList<>();
	            temp.add(dislike[0]);
	            graph.put(dislike[1], temp);
	        }
	        visited = new int[N + 1];
	        for(int i = 0; i < N; i++){
	            if(visited[i] == 0){
	                if(!dfs(i, 1)) return false;
	            }
	        }
	        return true;
	    }
	    private boolean dfs(int node, int color){
	        if(visited[node] != 0 && visited[node] != color) return false;
	        if(visited[node] == color) return true;
	        visited[node] = color;
	        List<Integer> neighbours = graph.get(node);
	        if(neighbours == null) return true;
	        for(Integer neighbour : neighbours){
	            if(!dfs(neighbour, -color)) return false;
	        }
	        return true;
	    }
	public boolean possibleBipartition_Wrong(int N, int[][] dislikes) {
		boolean possible = true;
		int[] arr1 = new int[N+1];
		int[] arr2 = new int[N+1];
		for(int i = 0; i < dislikes.length; i++) {
			int p1 = dislikes[i][0], p2 = dislikes[i][1]; 
			
			// if p1 is neither in arr1 nor in arr2, then try to insert
			// if successful good, else possible = false and break;
			if(arr1[p1] != 1 && arr2[p1] != 1) {
				if(arr1[p2] == 0) arr1[p1] = 1;
				else if(arr2[p2] == 0) arr2[p1] = 1;
				else {
					possible = false;
					break;
				}
			}
			
			if(arr1[p2] != 1 && arr2[p2] != 1) {
				if(arr1[p1] == 0) arr1[p2] = 1;
				else if(arr2[p1] == 0) arr2[p2] = 1;
				else {
					possible = false;
					break;
				}
			}
			
			if(arr1[p1] == 1 && arr1[p2] == 1) {
				possible = false;
				break;
			}
			
			if(arr2[p1] == 1 && arr2[p2] == 1) {
				possible = false;
				break;
			}
		}
		
		return possible;
    }
	

}
