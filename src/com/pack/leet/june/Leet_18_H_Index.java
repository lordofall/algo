package com.pack.leet.june;

/**

Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, 
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: 
"A scientist has index h if h of his/her N papers have at least h citations each, and the other N - h papers 
have no more than h citations each.
Input:
 [1,1,2,2,3,3,4,4,5,5]
 Output : 4
 
 Input:
 [0, 0]
 output: 0
 
 Input [0,0,1]
 output: 1
 
 Input: [1,1,2,3,4,5,7]
 Output: 3
 * @author LordOfAll
 *
 */

public class Leet_18_H_Index {

	public static void main(String[] args) {
		Leet_18_H_Index obj = new Leet_18_H_Index();
		int[] citations = {1,1,2,2,3,3,4,4,5,5};
		System.out.println(obj.hIndex(citations));
		
	}

	
	public int hIndex(int[] citations) {
		if(citations.length == 0) return 0;
        return bst(citations, 0, citations.length-1);
    }


	//ACCEPTED
	private int bst(int[] citations, int lo, int hi) {
		if(lo == hi) {
			return Math.min(citations[lo], citations.length-lo);
		}
		
		int mid = lo + (hi-lo)/2;
		
		int hIndexAtMid = Math.min(citations[mid], citations.length-mid);
		if(mid -1 >= lo) {
			int hIndexLeft = Math.min(citations[mid-1], citations.length - (mid-1));
			if(hIndexLeft > hIndexAtMid)
				return bst(citations, lo, mid-1);
		}
			
		if(mid+1 <= hi) {
			int hIndexRight = Math.min(citations[mid+1], citations.length - (mid+1));
			if(hIndexRight >= hIndexAtMid)
				return bst(citations, mid+1, hi);
		}
		
		return hIndexAtMid;
	}
	
	
}
