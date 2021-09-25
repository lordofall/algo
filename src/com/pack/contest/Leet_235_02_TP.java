package com.pack.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * @author LordOfAll
 *
 */
public class Leet_235_02_TP {

	public static void main(String[] args) {
		Leet_235_02_TP obj = new Leet_235_02_TP();

//		int[][] logs = {{0,5},{1,2},{0,2},{0,5},{1,3}};
//		int k = 5;
		
		int[][] logs = {{1,1},{2,2},{2,3}};
		int k = 4;

		System.out.println(Arrays.toString(obj.findingUsersActiveMinutes(logs, k)));
		
		

	}

	
	public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] output = new int[k];
        Map<Integer, Set<Integer>> idMinutes = new HashMap<>();
        for(int i = 0; i < logs.length; i++) {
        	Set<Integer> value = idMinutes.getOrDefault(logs[i][0], new HashSet<>());
        	value.add(logs[i][1]);
        	idMinutes.put(logs[i][0], value);
        }
        
        for(Set<Integer> minutes: idMinutes.values()) {
        	output[minutes.size()-1]++;
        }
        return output;
    }
	
}
