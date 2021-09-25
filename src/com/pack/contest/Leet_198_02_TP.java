package com.pack.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class Leet_198_02_TP {

	Map<Integer, List<Integer>> adjMap = null;
	String labels = null;
	public static void main(String[] args) {
		Leet_198_02_TP obj = new Leet_198_02_TP();
//		int n = 5;
//		int[][] edges = {{0,1},{0,2},{1,3},{0,4}};
//		String labels = "aabab"; // Output: [3,2,1,1,1]
		
		int n = 4;
		int[][] edges = {{0,2},{0,3},{1,2}};
		String labels = "aeed"; // Output:[1,1,2,1]
		
		System.out.println(Arrays.toString(obj.countSubTrees(n, edges, labels)));

	}

	public int[] countSubTrees(int n, int[][] edges, String labels) {
		
		adjMap = new HashMap<>();
		
		// it is a graph but a tree. so one element cannot have two parents.
		// so while creating adjacency list, we assume that edges[i][0] is parent
		// and edges[i][1] is child. just check, if edges[i][1] is not already a child, if so then
		// we have to make edge[i][1] pagent and edge[i][0] as child.
		List<Integer> children = new ArrayList<>();
		for(int i = 0; i < edges.length; i++) {
			int key = edges[i][0];
			int value = edges[i][1];
			if(children.contains(value)) {
				int tmp = key;
				key = value;
				value = tmp;
			}
			List<Integer> list = adjMap.getOrDefault(key, new ArrayList<>());
			list.add(value);
			children.add(value);
			adjMap.put(key, list);
		}
	    
		
		int[] result = new int[n];
		int[] visited = new int[n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(visited, 0);
			result[i] = countCharInSubtree(i, labels, labels.charAt(i), visited);
		}
		return result;
    }

	private int countCharInSubtree(int i, String labels, char x, int[] visited) {
		if(visited[i] == 1) return 0;
		
		visited[i]  = 1;
		
		int count = 0;
		if(x == labels.charAt(i))
			count++;
		
		List<Integer> children = adjMap.get(i);
		if(children != null) {
			for(int c: children) {
				count += countCharInSubtree(c, labels, x, visited);
			}
		}
		
		return count;
	}

}
