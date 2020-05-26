package com.pack.leet.may;

/*
Return the root node of a binary search tree that matches the given preorder traversal.
(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
*/
public class Leet_25_BST {

	public static void main(String[] args) {
		Leet_25_BST obj = new Leet_25_BST();
		int[] preorder = new int[] {8,5,1,7,10,12};
		TreeNode root = obj.bstFromPreorder(preorder);
		System.out.println(root);

	}

	
	public TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, 0, preorder.length-1);
    }
	
	public TreeNode bstFromPreorder(int[] preorder, int first, int last) {
		if(first == last) {
			return new TreeNode(preorder[first], null, null);
		}
		
		TreeNode root = new TreeNode(preorder[first], null, null);
		
		int mid = first+1;
		while(mid <= last && preorder[first] > preorder[mid]) mid++;
		
		if(first+1 <= mid-1) {
			TreeNode left = bstFromPreorder(preorder, first+1, mid-1);
			root.left = left;
		}
		
		if(mid <= last) {
			TreeNode right = bstFromPreorder(preorder, mid, last);
			root.right = right;
		}
		
		return root;
    }
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}


