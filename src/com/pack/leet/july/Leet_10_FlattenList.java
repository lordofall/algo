package com.pack.leet.july;


public class Leet_10_FlattenList {

	public static void main(String[] args) {
		Leet_10_FlattenList obj = new Leet_10_FlattenList();
		Node n1 = new Node(1,null,null,null);
		Node n2 = new Node(2,null,null,null);
		Node n3 = new Node(3,null,null,null);
		Node n4 = new Node(4,null,null,null);
		Node n5 = new Node(5,null,null,null);
		n1.next = n2;
		n2.prev = n1;
		n2.next = n3;
		n3.prev = n2;
		n2.child = n4;
		n4.next = n5;
		n5.prev = n4;
		
		Node flattend = obj.flatten(n1);
		obj.printFlattenList(flattend);
	}
	
	// ACCEPTED
	public Node flatten(Node head) {
		if(head == null) return head;
		
		Node rightDL = flatten(head.next);
		Node childDL = flatten(head.child);

		Node lastNodeOfChild = head;
		if(childDL != null) {
			head.next = childDL;
			childDL.prev = head;
			lastNodeOfChild = lastNode(childDL);
		}

		if(rightDL != null) {
			lastNodeOfChild.next = rightDL;
			rightDL.prev = lastNodeOfChild;
		}
		head.child = null; 
		return head;
    }
	
	private Node lastNode(Node head) {
		while(head.next != null) {
			head = head.next;
		}
		return head;
	}

	void printFlattenList(Node root) {
		while(root != null) {
			System.out.print(root.val + " ");
			root= root.next;
		}
			
	}

}

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
	public Node(int val, Node prev, Node next, Node child) {
		this.val = val;
		this.prev = prev;
		this.next = next;
		this.child = child;
	}
	
}
