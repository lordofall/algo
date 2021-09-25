package com.pack.contest;

import java.util.Arrays;

/*
 5211. Path with Maximum Probability
 
 You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.

Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000

Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.
 */
public class Leet_197_03_TP {

	public static void main(String[] args) {
		Leet_197_03_TP obj = new Leet_197_03_TP();
		int n = 3;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
		double[] succProb = { 0.5, 0.5, 0.2 };
		int start = 0;
		int end = 2;
		System.out.println(obj.maxProbability(n, edges, succProb, start, end));
	}

	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		double dist[] = new double[n];
		Boolean sptSet[] = new Boolean[n];
		Arrays.fill(dist, 0);
		Arrays.fill(sptSet, false);

		dist[start] = 1;

		int[][] graph = new int[n][n];
		for(int i =0; i < graph.length; i++) Arrays.fill(graph[i], 0);
		
		for(int i = 0; i < edges.length; i++) {
//			graph[edges[i][0]][edges[i][0]]
		}
		
		for (int count = 0; count < n - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices
			// not yet processed. u is always equal to src in first
			// iteration.
			int u = minDistance(dist, sptSet);

			// Mark the picked vertex as processed
			sptSet[u] = true;

			// Update dist value of the adjacent vertices of the
			// picked vertex.
			for (int v = 0; v < n; v++)

				// Update dist[v] only if is not in sptSet, there is an
				// edge from u to v, and total weight of path from src to
				// v through u is smaller than current value of dist[v]
				if (!sptSet[v] && edges[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] * edges[u][v] > dist[v])
					dist[v] = dist[u] * edges[u][v];
		}

		return 0d;
	}

	int minDistance(double dist[], Boolean sptSet[]) {
		double min = 0;
		int min_index = -1;
		for (int v = 0; v < dist.length; v++)
			if (sptSet[v] == false && dist[v] > min) {
				min = dist[v];
				min_index = v;
			}
		return min_index;
	}

}
