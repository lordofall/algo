package com.pack.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {

	public static void main(String[] args) {
		DFS obj = new DFS();
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}} ;
		System.out.println(obj.canFinish(numCourses, prerequisites));

	}

	
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		// create adjacency list
		Map<Integer, List<Integer>> adjMap = new HashMap<>();
		for(int i = 0; i < numCourses; i++) {
			List<Integer> value = adjMap.getOrDefault(prerequisites[i][1], new ArrayList<>());
			value.add(prerequisites[i][0]);
			adjMap.put(prerequisites[i][1], value);
		}
		
		int[] visited = new int[numCourses];
//		for(int i = 0; i < numCourses; i++) {
//			if(!canFinish(i, adjMap, visited))
//				return false;
//		}
		
		return canFinish(0, adjMap, visited);
		
	}


	private boolean canFinish(int x, Map<Integer, List<Integer>> adjMap, int[] visited) {
		if(visited[x] == 1) return true; // already visited
		
		visited[x] = 1;
		if(adjMap.containsKey(x)) {
			List<Integer> children = adjMap.get(x);
			for(Integer c: children)
				return canFinish(c, adjMap, visited);
		}
		else {
			return true; // came to lead
		}
		
		return false;
	}
}
