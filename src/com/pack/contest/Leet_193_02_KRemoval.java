package com.pack.contest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
5437. Least Number of Unique Integers after K Removals
Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.

Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2

4 4 1,1, 2, 3, 3, 3

4 - 1
2 - 1
1 - 2
2 - 3


Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.

Input: arr = [1], k = 1
Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length
 */
public class Leet_193_02_KRemoval {

	public static void main(String[] args) {
		Leet_193_02_KRemoval obj = new Leet_193_02_KRemoval();
		int[] arr = {5,5,5,1}; int k = 2;
		System.out.println(obj.findLeastNumOfUniqueInts(arr, k));
	}

	
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Arrays.sort(arr);
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		for(Integer key: map.keySet()) {
			queue.add(new Node(key, map.get(key)));
		}
		
		int countRemoved = queue.peek().value;
		while(countRemoved <= k) {
			if(queue.size() > 0) {
				queue.remove();
			}
			else {
				break;
			}
			Node n = queue.peek();
			if(n != null)
				countRemoved += n.value;
		}
			
		return queue.size();   
    }
}

class Node implements Comparable<Node>{
	Integer key;
	Integer value;
	Node(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}
	@Override
	public int compareTo(Node b) {
		return this.value- b.value;
	}
	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + "]";
	}
}
