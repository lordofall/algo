package com.pack.leet.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

import com.pack.common.Pair;

/*
Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.	

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 */
public class Leet_17_TopKFrequent {

	public static void main(String[] args) {
		
		Leet_17_TopKFrequent obj = new Leet_17_TopKFrequent();
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		System.out.println(Arrays.toString(obj.topKFrequent(nums, k)));
	}
	
	public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
        	map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a,d) ->  {
        	return d.getValue() - a.getValue();	
        });
        
        map.forEach((key,value) -> {
        	maxHeap.add(new Pair(key, value));
        });
        
        
        for(int i = 0; i < k; i++) {
        	result[i] = maxHeap.remove().getKey();
        }
        
        return result;
		
    }

}
