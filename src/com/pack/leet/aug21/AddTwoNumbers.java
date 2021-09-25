package com.pack.leet.aug21;
/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 * @author LordOfAll
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers obj = new AddTwoNumbers();
		
		int[] arr1 = {9,9,9,9,9,9,9};
		int[] arr2 = {9,9,9,9};
		ListNode l1 = createLinklist(arr1);
		ListNode l2 = createLinklist(arr2);
		ListNode result  = obj.addTwoNumbers2(l1,  l2);
		while(result !=null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	
	// this code is a bit slower than addTwoNumbers but more elegant.
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		int remaining = 0;
		while(l1 != null || l2 != null || remaining > 0) {
			int currentVal = remaining;
			if(l1 != null) {
				currentVal += l1.val;
				l1 = l1.next;
			}
			if(l2 != null) {
				currentVal += l2.val;
				l2 = l2.next;
			}
			
			remaining = currentVal / 10;
			currentVal = currentVal % 10;
			
			tail.next = new ListNode(currentVal);
			tail = tail.next;
		}
		return dummy.next;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode result = null;
		ListNode current = null;
		int remaining = 0;
		while(l1 != null || l2 != null || remaining > 0) {
			int currentVal = remaining;
			if(l1 != null) {
				currentVal += l1.val;
				l1 = l1.next;
			}
			if(l2 != null) {
				currentVal += l2.val;
				l2 = l2.next;
			}
			
			if(currentVal > 9) {
				currentVal = currentVal - 10;
				remaining = 1;
			}
			else {
				remaining = 0;
			}
			
			ListNode tmp = new ListNode(currentVal);
			
			if(result == null) {
				result = tmp;
				current = result;
			}
			else {
				current.next = tmp;
				current = current.next;
			}
		}
		return result;
    }
	
	private static ListNode createLinklist(int[] arr) {
		ListNode root = new ListNode(arr[0]);
		ListNode current = root;
		for(int i = 1; i < arr.length; i++) {
			ListNode tmp = new ListNode(arr[i], null);
			current.next = tmp;
			current = tmp;
		}
		return root;
	}



}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) {
		super();
		this.val = val;
	}
	ListNode(int val, ListNode next) {
		super();
		this.val = val;
		this.next = next;
	}
	
}
