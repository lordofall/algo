package com.pack.contest;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * @author LordOfAll
 *
 */
public class Leet_230_01_TP {

	public static void main(String[] args) {
		Leet_230_01_TP obj = new Leet_230_01_TP();

		// items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]]
		List<List<String>> items = Arrays.asList(Arrays.asList("phone","blue","pixel"), Arrays.asList("computer","silver","lenovo"),  Arrays.asList("phone","gold","iphone"));
		String ruleKey = "color", ruleValue = "silver";
		System.out.println(obj.countMatches(items, ruleKey, ruleValue));

	}

	
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int count = 0;
		for (List<String> item : items) {
			if (ruleKey.equals("type")) {
				if(item.get(0).equals(ruleValue)) count++;
			}

			if (ruleKey.equals("color")) {
				if(item.get(1).equals(ruleValue)) count++;
			}

			if (ruleKey.equals("name")) {
				if(item.get(2).equals(ruleValue)) count++;
			}
		}
		return count;
	}
	
}
