package com.pack.leet.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/*
 Implement a trie with insert, search, and startsWith methods.
 
 Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
 */
public class Leet_14_Trie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("app");
		trie.insert("back");
		trie.insert("apple");
		System.out.println(trie.startsWith("app"));
//		System.out.println(Arrays.asList(trie.root));
	}

}

class Trie {
	public Map<Character, Node> root;
	 /** Initialize your data structure here. */
    public Trie() {
    	root = new HashMap<>();
    	Node value = new Node(new HashMap<>(), false);
        root.put(null, value);
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] charArr = word.toCharArray();
        Map<Character, Node> children = root.get(null).getMap();
        for(int i=0; i < charArr.length; i++) {
        	Node temp = null;
        	if(!children.containsKey(charArr[i])) {
        		temp = new Node(new HashMap<>(), false);
        	}
        	else {
        		temp = children.get(charArr[i]);
        	}
        	if(i == charArr.length-1)
        		temp.setComplete(true);
        	children.put(charArr[i], temp);
        	children = children.get(charArr[i]).getMap();
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	char[] charArr = word.toCharArray();
    	 Map<Character, Node> children = root.get(null).getMap();
    	 for(int i = 0; i < charArr.length; i++) {
    		 if(!children.containsKey(charArr[i])) return false;
    		 if(i == charArr.length-1) {
    			 return children.get(charArr[i]).isComplete();
    		 }
    		 children = children.get(charArr[i]).getMap();
    	 }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		char[] charArr = prefix.toCharArray();
		Map<Character, Node> children = root.get(null).getMap();
		for (int i = 0; i < charArr.length; i++) {
			if (!children.containsKey(charArr[i]))
				return false;

			children = children.get(charArr[i]).getMap();
		}
		return true;
	}
}

class Node {
	Map<Character, Node> map;
	boolean complete = false;
	
	public Node(Map<Character, Node> map, boolean complete) {
		this.map = map;
		this.complete = complete;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public Map<Character, Node> getMap() {
		return map;
	}
	public void setMap(Map<Character, Node> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "(" + Arrays.asList(map) + "," + complete + ")";
	}
	
}