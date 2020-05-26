package com.pack.leet.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leet_01_Contest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 Input: target = [1,3], n = 3
Output: ["Push","Push","Pop","Push"]
		 */
		
		int[] target = new int[] {2,3,4};
		int n = 4;
		List<String> result = buildArray(target, n);
		
		for(String str: result) {
			System.out.print(str + " ");
		}
	}
	
	public static List<String> buildArray(int[] target, int n) {
		List<String> result = new ArrayList<>();
		
		List<Integer> targetList = Arrays.stream(target).boxed().collect(Collectors.toList());
		int index = 0;
		for(int i = 1; i <= n; i++) {
			if(targetList.contains(i)) {
				result.add("Push");
				index++;
			}
			else if(targetList.size() > index){
				result.add("Push");
				result.add("Pop");
			}
			
		}
		
		return result;
    }

}
