package com.pack.leet.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.pack.leet.june.TreeNode;

/*
Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
output:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class Leet_02_BinaryTreeTraversal {

	public static void main(String[] args) {
		Leet_02_BinaryTreeTraversal obj = new Leet_02_BinaryTreeTraversal();
		Integer[] elements = {3,9,20,null,null,15,7};
		
//		TreeNode root = obj.createTree(elements, 0);
	}

	// COPIED
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
	       List<List<Integer>> result = new ArrayList<>();
	       if(root == null)
	    	   return result;
	       
	       LinkedList<TreeNode> current = new LinkedList<>();
	       LinkedList<TreeNode> next = new LinkedList<>();
	       current.offer(root);
	       
	       List<Integer> numberList = new ArrayList<>();
	       
	       while(!current.isEmpty()) {
	    	   TreeNode head = current.poll();
	    	   numberList.add(head.val);
	    	   
	    	   if(head.left != null)
	    		   next.offer(head.left);
	    	   if(head.right != null)
	    		   next.offer(head.right);
	    	   
	    	   if(current.isEmpty()) {
	    		   current = next;
	    		   next = new LinkedList<>();
	    		   result.add(numberList);
	    		   numberList = new ArrayList<>();
	    	   }
	       }
	       
	       //Collections.reverse(result);
	       return result;
	 }
	
	private int height(TreeNode root) {
		if(root == null) return 0;
		
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		if(lHeight > rHeight)
			return lHeight+1;
		else
			return rHeight + 1;
	}
	
}
