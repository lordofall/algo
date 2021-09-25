package com.pack.leet.sep21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Count number of trees in a forest
 * Given n nodes of a forest (collection of trees), find the number of trees in the forest.
 * Input :  edges[] = {0, 1}, {0, 2}, {3, 4}
 * Output : 2
 * 
 * Explanation : There are 2 trees
 *                  0       3
 *                 / \       \
 *                1   2       4        
 *                           
 * @author LordOfAll
 *
 */
public class TreesInForest {

	public static void main(String[] args) {
		int[][] edges = {{0, 1}, {0, 2}, {3, 4}};
		Set<Integer> vertices = new HashSet<Integer>();
		for(int[] edge: edges) {
			vertices.add(edge[0]);
			vertices.add(edge[1]);
		}
		Integer[] vertexArr = new Integer[vertices.size()];
		var i = 0;
		for(Integer v: vertices) {
			vertexArr[i] = v;
			i++;
		}
		Map<Integer, List<Integer>> adjacencyList = createAdjacencyList(edges, vertexArr);
		int noOfTree = dfs(adjacencyList, vertexArr);
		System.out.println("noOfTree "+noOfTree);
	}

	private static Map<Integer, List<Integer>> createAdjacencyList(int[][] edges, Integer[] vertexArr) {
		Map<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
		for(int vertex: vertexArr) {
			adjacencyList.put(vertex, new ArrayList<Integer>());
		}
		
		for(int[] edge: edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
		}
		return adjacencyList;
	}

	/*dfs(G):
	 * 	while all vertices are not visited do:
	 * 		put unvisited vertex in stack
	 * 			while stack is not empty
	 * 				p = stack.poll
	 * 				if(p is not visited)
	 * 					print p, mark p visited
	 * 					push all unvisited neighbor of p into stack
	 */
	private static int dfs(Map<Integer, List<Integer>> adjacencyList, Integer[] vertexArr) {
		int noOfTree = 0;
		
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		int i=0;
		for(Integer v: vertexArr) {
			visited.put(v, false);
			i++;
		}
		Stack<Integer> stack = new Stack<Integer>();
		for(int v: vertexArr) {
			if(!visited.get(v)) {
				noOfTree++;
				stack.push(v);
				while(!stack.isEmpty()) {
					int p = stack.pop();
					System.out.println(p);
					visited.put(p, true);
					
					List<Integer> neighbors = adjacencyList.get(p);
					for(int n: neighbors) {
						if(!visited.get(n))
							stack.push(n);
					}
					
				}
			}
		}
		return noOfTree;
		
	}

}
