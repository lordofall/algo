package com.pack.javasnippet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JavaTest {

	public static void main(String[] args) {
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		
		map.put(1, new Node(5));
		map.put(2, new Node(10));
		for(var entry: map.entrySet()) {
			System.out.println(entry.getKey() + "--" + entry.getValue().x);
		}
		
		Node n = map.get(2);
		n.x = 15;
		
		for(var entry: map.entrySet()) {
			System.out.println(entry.getKey() + "--" + entry.getValue().x);
		}
		
	}
	
	private boolean isValidIP(String ip) {
		String[] groups = ip.split("\\.");
		
		if(groups.length != 4) return false;
		
		 return Arrays.stream(groups)
		 	.filter(s -> s.length() > 0)
		 	.map(Integer::parseInt)
		 	.filter(x -> x >=0 && x <= 255)
		 	.count() == 4;
	}
}


class Node {
	int x;
	Node(int x) {
		this.x = x;
	}
}