package com.pack.leet.may;

public class Leet_16_OddEvenList {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2, 3, 4, 5, 6};
		ListNode root = new ListNode(arr[0], null);
		ListNode current = root;
		for(int i = 1; i < arr.length; i++) {
			current.next = new ListNode(arr[i], null);
			current = current.next;
		}
		
		// iterate
		current = oddEvenList(root);
		while(current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
			
	}

	public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
		
		ListNode odd = head;
        ListNode even = head.next;
        ListNode even_beg = head.next;
       
        while (even != null) {
        	odd.next = even.next;
        	
        	if(odd.next != null)
        		even.next = odd.next.next;
        	else {
        		odd.next = even_beg;
        		break;
        	}
        	
        	if(odd.next.next == null) {
        		odd.next.next = even_beg;
        		break;
        	}
        	
        	odd = odd.next;
        	even = even.next;
        	
        }
        return head;
    }
	
	public static ListNode oddEvenList2(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}


class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	      
}