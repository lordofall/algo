package com.pack.leet.sep21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * find single source shortest path using bfs
 * this will work for only unweighted graph 
 * 
 * for sssp, dfs never works.
 * @author LordOfAll
 *
 */
public class SSSPBFS {

	public static void main(String[] args) {
		char[] vertices = { 'B', 'C', 'D', 'E', 'A', 'P'};
		char[][] edges = {{'A', 'B'}, {'A', 'C'}, {'B', 'D'}, {'B', 'E'},
				{'D', 'E'}};
		Map<Character, List<Character>> adjacencyList = createdjacencyList(edges);
		bfs(vertices, adjacencyList);
	}

	/*
	 * bfs(G):
	 * 		while all vertices are not visted:
	 * 			enqueue first vertex
	 * 			while(queue is not empty)
	 * 				p = dequeue
	 * 				if p is not visited
	 * 					print p, mark p as visited
	 * 					enqueue all unvisited neighbor vertices of p
	 */
	private static void bfs(char[] vertices, Map<Character, List<Character>> adjacencyList) {
		Map<Character, Boolean> visited = new HashMap<Character, Boolean>();
		for(char c: vertices) {
			visited.put(c, false);
		}
		
		Queue<Character> queue = new PriorityQueue<>();
		for(char c: vertices) {
			if(!visited.get(c)) {
				queue.add(c);
				while(!queue.isEmpty()) {
					char p = queue.poll();
					if(!visited.get(p)) {
						System.out.println(p);
						visited.put(p, true);
						List<Character> neighbors = adjacencyList.get(p);
						if (neighbors != null) {
							for (char n : neighbors) {
								if (!visited.get(n)) {
									
									queue.add(n);
								}
							} 
						}
					}
				}
			}
		}
	}

	private static Map<Character, List<Character>> createdjacencyList(char[][] edges) {
		Map<Character, List<Character>> map = new HashMap<>();
		
		for(int i = 0; i < edges.length; i++) {
			List<Character> list = map.getOrDefault(map.get(edges[i][0]), new ArrayList<Character>());
			list.add(edges[i][1]);
			map.put(edges[i][0], list);
		}
		
		return map;
	}

}

class Vertex<T> {
	T val;
	Vertex<T> parent;
	
	public Vertex(T val, Vertex<T> parent) {
		super();
		this.val = val;
		this.parent = parent;
	}
	
	
}

class Edge<T> {
	T source;
	T dest;
}
