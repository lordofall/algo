package com.pack.leet.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/*
 Given a string, sort it in decreasing order based on the frequency of characters.
 
Input:
"tree"

Output:
"eert"
 */
public class Leet_23_SortByFreq {

	public static void main(String[] args) {
		Leet_23_SortByFreq obj = new Leet_23_SortByFreq();
		System.out.println(obj.frequencySort("tree"));
	}

	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
		
		maxHeap.addAll(map.keySet());
		
		StringBuilder result = new StringBuilder();
		while(!maxHeap.isEmpty()) {
			char current = maxHeap.remove();// aaaaaa
			IntStream.range(0, map.get(current)).forEach(i -> result.append(current));
		}
		return result.toString();
	}
}
