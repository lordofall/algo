package com.pack.leet.july;

import com.pack.leet.june.ListNode;

/*
Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5


 */
public class Leet_19_RemoveFromLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// COPIED
	 public ListNode removeElements(ListNode head, int val) {
	       while(head!=null && head.val == val){
	            head = head.next;
	           }
	        if(head==null)
	            return null;
	        ListNode prev = head;
	        ListNode next = head.next;
	        while(next!=null){
	            if(next.val== val){
	              prev.next = next.next;
	                next = next.next;
	                continue;
	           
	            }
	            prev = next;
	            next = next.next;
	        }
	       
	       
	        return head;
	    }
}
