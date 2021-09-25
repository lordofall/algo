package com.pack.leet.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

 */
public class Leet_12_RandomizedSet {
	
	
	public static void main(String[] args) {

	}
	
	private List<Integer> list;
    private Map<Integer, Integer> map;
     
    /** Initialize your data structure here. */
    public Leet_12_RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
     
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
         
        int index = list.size();
        list.add(val);
        map.put(val, index);
         
        return true;
    }
     
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
         
        int indexRemove = map.get(val);
        int tail = list.get(list.size() - 1);
         
        swap(indexRemove, list.size() - 1);
        map.put(tail, indexRemove);
        list.remove(list.size() - 1);
        map.remove(val);
         
        return true;
    }
     
    /** Get a random element from the set. */
    public int getRandom() {
         
        if (list.isEmpty()) {
            return 0;
        }
         
        Random rand = new Random();
        int index = rand.nextInt(list.size());
         
        return list.get(index);
    }
     
    private void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}

