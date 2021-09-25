package com.pack.leet.may;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
K Closest Points to Origin
We have a list of points on the plane.  
Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the 
Euclidean distance.)

You may return the answer in any order.  
The answer is guaranteed to be unique 
(except for the order that it is in.)

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
 */
public class Leet_31_KClosest {

	public static void main(String[] args) {
		Leet_31_KClosest obj = new Leet_31_KClosest();
		int[][] points = new int[][] { new int[] { 3, 3 }, new int[] { 5, -1 }, new int[] { -2, 4 }};
		int K = 2;
		System.out.println(Arrays.deepToString(obj.kClosest(points, K)));
	}

	public int[][] kClosest(int[][] points, int K) {
		int result[][] = new int[K][2];
		int rows = points.length;
		PriorityQueue<Point> minHeap = new PriorityQueue<>((a, b) ->  {
			if(a.distance < b.distance) return -1;
			else return 1;
		});
		for(int i = 0; i < rows; i++) {
			int x = points[i][0]; int y = points[i][1];
			minHeap.add(new Point(x, y, Math.abs(x*x + y*y)));
		}
		
		for(int i = 0; i < K; i++ ) {
			Point p = minHeap.remove();
			result[i][0] = p.x;
			result[i][1] = p.y;
		}
		return result;
	}

	class Point {
		int x,y; 
		double distance;
		Point(int x, int y, double distance) {
			this.x = x; this.y= y; this.distance=distance;
		}
	}
}


