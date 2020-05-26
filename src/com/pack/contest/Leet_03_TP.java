package com.pack.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 Given the array favoriteCompanies where favoriteCompanies[i] is the list of favorites companies for the ith person (indexed from 0).

Return the indices of people whose list of favorite companies is not a subset of any other list of favorites companies. You must return the indices in increasing order.

Input: favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
Output: [0,1,4] 

 */
public class Leet_03_TP {

	public static void main(String[] args) {
		List<List<String>> favCompanies = new ArrayList<>();
		List<String> list1 = Arrays.asList("leetcode","google","facebook");
		List<String> list2 = Arrays.asList("google","microsoft");
		List<String> list3 = Arrays.asList("google","facebook");
		List<String> list4 = Arrays.asList("google");
		List<String> list5 = Arrays.asList("amazon");
		
		favCompanies.add(list1);favCompanies.add(list2);favCompanies.add(list3);favCompanies.add(list4);favCompanies.add(list5);
		
		System.out.println(peopleIndexes(favCompanies));
	}
	public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
		List<Integer> result = new ArrayList<>();
		List<String> newList = new ArrayList<>();
		for(List<String> list: favoriteCompanies) {
			Collections.sort(list);
			newList.add(String.join("", list));
		}
		
		for(int i = 0; i < newList.size(); i++) {
			boolean subset = false;
			for(int j = 0; j < newList.size(); j++) {
				if(i != j && newList.get(j).contains(newList.get(i))) {
					subset = true; break; 
				}
			}
			if(!subset) {
				result.add(i);
			}
		}
		
		return result;
	}
}
