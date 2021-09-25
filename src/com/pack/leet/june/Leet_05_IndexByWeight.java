package com.pack.leet.june;

import java.util.Random;

/*
Randomly pick index by weight.
Given an array w = [1,2,3,4]
w[i] is weight of ith index. method pickIndexByWight 
will return index (0,1,2 or 3) in proportion to its weight.

so indices in proportion to its weight will be like following.
new array of indices based on weight: 0 1 1 2 2 2 3 3 3 3

now random pick a number x between 0 and 10. 
and return newarray[x]

or create a perfix-sum array,
1 3 6 10
*/
public class Leet_05_IndexByWeight {
	int[] prefixSum;
	int total;
	public static void main(String[] args) {
		int[] w = new int[] {1,3};
		Leet_05_IndexByWeight obj = new Leet_05_IndexByWeight(w);
		System.out.println(obj.pickIndexByWeight());
		System.out.println(obj.pickIndexByWeight());
		System.out.println(obj.pickIndexByWeight());
		System.out.println(obj.pickIndexByWeight());
		System.out.println(obj.pickIndexByWeight());
		System.out.println(obj.pickIndexByWeight());
		System.out.println(obj.pickIndexByWeight());
		System.out.println(obj.pickIndexByWeight());
		System.out.println(obj.pickIndexByWeight());
		System.out.println(obj.pickIndexByWeight());
	}
	
	Leet_05_IndexByWeight(int[] w) {
		 prefixSum = new int[w.length];
	        int sum = 0;
	        for(int i = 0; i < w.length; i++){
	            sum += w[i];
	            prefixSum[i] = sum;
	        }
	}
   
    public int pickIndex() {
        double target = prefixSum[prefixSum.length - 1] * Math.random();
        for(int i = 0; i < prefixSum.length; i++){
            if(target < prefixSum[i]) return i;
        }
        return -1;
    }
	
	/// wrong 
	
	int pickIndexByWeight() {
		double random = Math.random();
		return searchInprefixArray((int) (random*total), 0, prefixSum.length-1);
	}

	private int searchInprefixArray(int x, int lo, int hi) {
		if(hi == lo) return lo;
		int mid = lo + (hi-lo)/2;
		if(x >= prefixSum[mid]) return searchInprefixArray(x, mid, hi);
		else return searchInprefixArray(x, lo, mid-1);
	}

}
