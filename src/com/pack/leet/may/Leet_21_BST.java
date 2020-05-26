package com.pack.leet.may;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
You may assume k is always valid, 1 <= k <= BST's total elements.
Input: root = [3,1,4,null,2], k = 1
Output: 1
 */
public class Leet_21_BST {

	public static void main(String[] args) {
		int[] arr = new int[] {3,1,4,2};
		
		TreeNode root = createBST(arr);
		
		System.out.println(kthSmallest(root, 1));
	}

	static int kthSmallest(TreeNode root, int k) {
		List<Integer> sortedList = new ArrayList<>();
		inorder(root, sortedList);
		return sortedList.get(k-1);
	}
	
	static void inorder(TreeNode root, List<Integer> list) {
		if(root.left != null) inorder(root.left, list);
		list.add(root.val);
		if(root.right != null) inorder(root.right, list);
	}
	
	static TreeNode createBST(int[] arr) {
		TreeNode root = new TreeNode(arr[0], null, null);
		
		for(int i = 1; i < arr.length; i++) {
			insert(root,arr[i]);
		}
		
		return root;
	}
	
	static void insert(TreeNode root, int x) {
		if (x < root.val) {// go left
			if (root.left != null) {
				insert(root.left, x);
			} else {
				root.left = new TreeNode(x, null, null);
			}
		} else {
			if (root.right != null)
				insert(root.right, x);
			else {
				root.right = new TreeNode(x, null, null);
			}
		}
	}
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