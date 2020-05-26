package com.pack.contest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 Given a sentence text (A sentence is a string of space-separated words) in the following format:

First letter is in upper case.
Each word in text are separated by a single space.
Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths. If two words have the same length, arrange them in their original order.

Return the new text following the format shown above.

Input: text = "Leetcode is cool"
Output: "Is cool leetcode"
Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
Output is ordered by length and the new first word starts with capital letter.
 */
public class Leet_02_Sort {

	public static void main(String[] args) {
		System.out.println(arrangeWords("Leetcode is cool"));

	}

   static String arrangeWords(String text) {
	 String[] strArr = text.split(" ");
	 List<String> strList = Arrays.asList(strArr);
	 strList.sort((s1, s2) -> s1.length() - s2.length());

	 
	 String result = strList.stream()
		      .map(n -> String.valueOf(n).toLowerCase())
		      .collect(Collectors.joining(" "));
     return result.substring(0, 1).toUpperCase() + result.substring(1);   
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   static void sort(String[] arr, int l, int r) {
	   if(l == r) return;
	   
	   int mid = l + (r-l)/2;
	   
	   sort(arr, l, mid);
	   sort(arr, mid+1, r);
	   merge(arr, l, mid, r);
   }
   
   static String[] merge(String[] arr, int left, int mid, int right) {
	   
	   // Find sizes of two subarrays to be merged 
       int n1 = mid - left + 1; 
       int n2 = right - mid; 
 
       /* Create temp arrays */
       String nums1[] = new String [n1]; 
       String nums2[] = new String [n2]; 
 
       /*Copy data to temp arrays*/
       for (int i=0; i<n1; ++i) 
    	   nums1[i] = arr[left + i]; 
       for (int j=0; j<n2; ++j) 
    	   nums1[j] = arr[mid + 1+ j]; 
       
       String[] merged = new String[nums1.length+nums2.length];
       
       int l = 0; int r = 0; int m = 0; 
       while(l < nums1.length && r < nums2.length) {
           if(nums1[l].length() < nums2[r].length())
               merged[m++] = nums1[l++];
           else
               merged[m++] = nums2[r++];
       }
       
       while(l < nums1.length)
           merged[m++] = nums1[l++];
       
       while(r < nums2.length)
           merged[m++] = nums2[r++];
       
       return merged;
       
	}
}
