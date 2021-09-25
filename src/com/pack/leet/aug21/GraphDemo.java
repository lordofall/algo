package com.pack.leet.aug21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphDemo {

	public static void main(String[] args) {
		char[] vertices = { 'B', 'C', 'D', 'E', 'A'};
		char[][] edges = {{'A', 'B'}, {'A', 'C'}, {'B', 'D'}, {'B', 'E'},
				{'D', 'E'}};
		// here adjacency list is map with key as character and value as list as vertices are character
		// if vertices are number from 0 to 10, then we can use array of list. array index can 
		// server as key.
		Map<Character, List<Character>> adjacencyList = createAdjacencyList(edges);
		
		// BFS
		bfs(vertices, adjacencyList);
	}
	
	//	bfs(G)
	//		while all vertices are not explored
	//			enqueue(any vertex)
	//			while queue is not empty
	//				p = dequeue()
	//				if (p is not visited)
	//					print p, mark p as visited
	//					enqueue all unvisited neighbor of p
	private static void bfs(char[] vertices, Map<Character, List<Character>> adjacencyList) {
		Map<Character, Boolean> visited = new HashMap<>();
		for(int i = 0; i < vertices.length; i++) {
			visited.put(vertices[i], false);
		}
		Queue<Character> queue = new PriorityQueue<Character>();
		
		for(int i = 0; i< vertices.length; i++) {
			if(!visited.get(vertices[i])) {
				queue.add(vertices[i]);
				while(!queue.isEmpty()) {
					char p = queue.poll();
					if(!visited.get(p)) {
						System.out.print(p + " ");
						visited.put(p, true);
						List<Character> neighbour = adjacencyList.get(p);
						if(neighbour != null) {
							for(char n: neighbour) {
								if(!visited.get(n))
									queue.add(n);
							}
						}
						
					}
				}
			}
		}
		
	}

	/**
	 * TODO what if graph is disjointed. so 
	 * @param edges
	 * @return
	 */
	private static Map<Character, List<Character>> createAdjacencyList(char[][] edges) {
		Map<Character, List<Character>> adjacencyList = new HashMap<>();
		for(int i = 0; i < edges.length; i++) {
			List<Character> list = adjacencyList.getOrDefault(edges[i][0], new ArrayList<Character>());
			list.add(edges[i][1]);
			adjacencyList.put(edges[i][0], list);
		}
		return adjacencyList;
	}

}

