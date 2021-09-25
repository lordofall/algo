package com.pack.contest;

import java.util.ArrayList;
import java.util.List;

public class Leet_197_02_TP {

	public int numSub(String s) {
		int result = 0;
		List<Integer> list = new ArrayList<>();
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1') {
				count++;
			}
			else {
				if(count > 0) list.add(count);
				count = 0;
			}
		}
		if(count > 0) list.add(count);
		
		double m = Math.pow(10, 9) + 7;
		
		for(int i = 0; i < list.size(); i++) {
			int num = list.get(i);
			while(num > 0) {
				// 10^9 + 7
				result = (int) ((result + num)%m);
				num--;
			}
		}
		return result;
    }

	public static void main(String[] args) {
		Leet_197_02_TP obj = new Leet_197_02_TP();
		String s = "0110111";
		System.out.println(obj.numSub(s));
		
	}
	
}
