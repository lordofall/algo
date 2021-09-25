package com.pack.leet.june;
/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
Input: head = [4,5,1,9], node = 5
Output: [4,1,9] 	
 */
public class Leet_02_LLDelete {
	static ListNode head = null;
	public static void main(String[] args) {
		Leet_02_LLDelete obj = new Leet_02_LLDelete();
		int[] input = new int[] {4,5,1,9};
		head = obj.createLinkedList(input);
//		obj.deleteNode(new ListNode(1), head);
		obj.deleteNode(new ListNode(1));
		printLL();
	}

	private static void printLL() {
		ListNode current = head;
		while(current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}
	// ACCEPTED
	public void deleteNode(ListNode node) {
			node.val = node.next.val;
			node.next = node.next.next;
	}
	
	private ListNode createLinkedList(int[] input) {
		ListNode head = new ListNode(input[0]);
		ListNode current = head;
		for(int i = 1; i < input.length; i++) {
			current.next = new ListNode(input[i]);
			current = current.next;
		}
		return head;
	}
	
	public void deleteNode(ListNode node, ListNode head) {
        ListNode current = head;
        if(current.val == node.val) {
        	head = current.next;
        	return;
        }
        	
        while(current.next != null) {
        	if(current.next.val == node.val) {
        		current.next = current.next.next;
        		return;
        	}
        	current = current.next;
        }
    }
}
