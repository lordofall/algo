package com.pack.leet.may;

import java.util.Arrays;
import java.util.Scanner;

public class MinHeap {

	
    private static int[] heap = null;
    private static int heapSize = 0;
   
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       int noOfOperation = scanner.nextInt();
       heap = new int[noOfOperation];
       
       for(int i = 0; i < noOfOperation; i++) {
           int instruction = scanner.nextInt();
           if(instruction == 1) {
               int val = scanner.nextInt();
               heap[heapSize] = val;
               heapifyUp(heap,heapSize);
               heapSize++;
           }else if(instruction == 2) {
               int val = scanner.nextInt();
               int indexTobeDeleted = findIndex(heap, val);
               delete(heap, indexTobeDeleted);
           } else if(instruction == 3) {
               System.out.println(heap[0]); //minimum element
               
           }

       } 

       scanner.close();
    }
	
	private static int findIndex(int[] heap, int val) {
		for(int i = 0; i < heapSize; i++) {
			if(heap[i] == val) return i;
		}
		return 0;
	}

	private static void delete(int[] heap, int index) {
		heap[index] = heap[--heapSize]; 
//		heapSize--;
		if(heap[index] < heap[parentIndex(index)]) {
			heapifyUp(heap, index);
		}
		else {
			heapifyDown(heap, index);
		}
	}

	private static void heapifyDown(int[] heap, int index) {
		int lCIndex = leftChildIndex(index);
		int rCIndex = rightChildIndex(index);
		
		if(lCIndex > heapSize && rCIndex > heapSize) return; // no child element
		
		else if(lCIndex<= heapSize && rCIndex <= heapSize) { // left and right child element both present
			if(heap[lCIndex] < heap[rCIndex]) {
				if(heap[index] > heap[lCIndex]) {
					swap(heap, lCIndex, index);
					heapifyDown(heap, lCIndex);
				}
					
			}
			else {
				if(heap[index] > heap[rCIndex]) {
					swap(heap, rCIndex, index);
					heapifyDown(heap, lCIndex);
				}
			}
		}
		
		else if(lCIndex<= heapSize && rCIndex > heapSize) { // only left child present
			if(heap[lCIndex] < heap[rCIndex]) {
				if(heap[index] > heap[lCIndex]) {
					swap(heap, lCIndex, index);
					heapifyDown(heap, lCIndex);
				}
			}
		}
		
		else if (lCIndex > heapSize && rCIndex <= heapSize) { // only right child present: not possible
			
		}
		
		
	}

	/**
	 * i is the index of last element and it has to find its right place in the heap. 
	 * @param heap
	 * @param x
	 */
	static void heapifyUp(int[] heap, int i) {
		if(i == 0) return; // root node
		int p = parentIndex(i);
		if(heap[p] > heap[i]) {
			swap(heap, p, i);
			heapifyUp(heap, p);
		}
		else {
			return;
		}
	}
	
	static void swap(int[] heap, int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
	static int parentIndex(int x) {
		return (x-1)/2;
	}
	
	static int leftChildIndex(int x) {
		return x*2+1;
	}
	
	static int rightChildIndex(int x) {
		return x*2+2;
	}
}
