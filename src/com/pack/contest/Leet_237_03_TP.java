package com.pack.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 5736. Single-Threaded CPU
 * 
 * @author LordOfAll
 *
 */
public class Leet_237_03_TP {

	public static void main(String[] args) {
		Leet_237_03_TP obj = new Leet_237_03_TP();
		int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
		
		System.out.println(obj.getOrder(tasks));
	}


	public int[] getOrder(int[][] tasks) {
        int[] result = new int[tasks.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
        	List<Integer> val = map.getOrDefault(tasks[i][0], new ArrayList<>());
        	val.add(tasks[i][1]);
        	map.put(tasks[i][0], val);
        }
        
        return result;
    }
}
