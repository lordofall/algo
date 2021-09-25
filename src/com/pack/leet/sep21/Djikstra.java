package com.pack.leet.sep21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * given a graph and source vertex, find shortest path from source vertex
 * 
 * In Djisktra, we have to use minheap.  Create a minheap, add all vertex and the cost as infinity for all except source
 * vertex. For source vertex, it is zero.
 * 
 * Djikstra(G, S):
 * 		set the distance of all vertex to infinity except source vertiex to 0
 * 		put all vertex in minheap
 * 		while minheap is not empty
 * 			currentVertex = extract from minheap
 * 			for each neighbor of p
 * 				if currentVertex.distance + currentEdge < neightbor.distace
 * 					update neighbor's distance to currentVertex.distance + currentEdge and parent of the neighbor
 * 
 * @author LordOfAll
 *
 */
public class Djikstra {

	public static void main(String[] args) {

        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        
        Djikstra obj = new Djikstra();
        obj.djikstra(graph, 0);

	}

	private void djikstra(int[][] graph, int s) {
		// no of vertex
		int noOfVertex = graph.length;
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		
		
		// this distance map keeps the vertex and its distance
		PriorityQueue<Node> minheap = new PriorityQueue<Node>( (a, d) ->  a.distance - d.distance);
		
		for(int i = 0; i < noOfVertex; i++) {
			Node n;
			if(i == s)
				n = new Node(i, 0, null);
			else
				n = new Node(i, Integer.MAX_VALUE, null);
			map.put(i, n);
			minheap.add(map.get(i));
			
		}
		
		// while minheap is not empty
		// 		currentNode = extract from minheap
		//		for all neighbors of currentNode
		//			if(currentNode.distance + currentEdge < neightbor.distance)
		//					neighbor.distance = currentNode.distance + currentEdge
		//					neighbor.parent = currentNode.vertex
		while(!minheap.isEmpty()) {
			Node currentNode = minheap.peek();
			for(int j = 0; j < graph[currentNode.vertex].length; j++) {
				if(graph[currentNode.vertex][j] != 0) {
					Node neighbor = map.get(j);
					int newDistance = currentNode.distance + graph[currentNode.vertex][j];
					if(newDistance < neighbor.distance) {
						neighbor.distance = newDistance;
						neighbor.parent = currentNode;
						
					}
				}
			}
			// removing the minimum element in the last so that heapify will be called again.
			minheap.poll();
			
		}
		System.out.println("----------");
		for(var entry: map.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue().distance + " | ");
			Node parent = entry.getValue().parent;
			while(parent != null) {
				System.out.print(parent.vertex + " ");
				parent = parent.parent;
			}
				
			System.out.println("\n---");
		}
		
	}

	

}

class Node {
	Integer vertex;
	int distance;
	Node parent;
	public Node(Integer vertex, int distance, Node parent) {
		super();
		this.vertex = vertex;
		this.distance = distance;
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "Node [vertex=" + vertex + ", distance=" + distance + "]";
	}
	
	
}
