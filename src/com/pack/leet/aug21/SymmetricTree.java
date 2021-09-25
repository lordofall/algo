package com.pack.leet.aug21;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 * 101. Symmetric Tree
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * @author LordOfAll
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {
//		Integer[] arr = {1,2,2,3,4,4,3}; // true
		Integer[] arr = {1,2,2,2,null,2}; // false
		
		TreeNode root = new TreeNode(arr[0]);
		createTree(root,arr, 0);
//		System.out.println("time taken in creating tree "+ Duration.between(now, Instant.now()).toMillis());
		
		System.out.println(isSymmetric2(root));
	}

	//  no recursion; use stack: ACCEPTED
		public static boolean isSymmetric2(TreeNode root) {
			if(root == null) return true;
			
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root.left);
			stack.push(root.right);
			
			while(!stack.isEmpty()) {
				TreeNode right = stack.pop();
				TreeNode left = stack.pop();
				
				if(left != null && right != null) {
					if(left.val != right.val) 
						return false;
					else {
						stack.push(left.left);
						stack.push(right.right);
						stack.push(left.right);
						stack.push(right.left);
					}
				}
				else if(left == null && right != null){
					return false;
				}
				else if(left != null && right == null) {
					return false;
				}
			}
			return true;
	    }
	
	// using recursion : ACCEPTED
	public static boolean isSymmetric(TreeNode root) {
		return isSymmetric(root.left, root.right);
    }
	
	
	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null || right == null) {
			return left==right;
		}
		
		if(left.val != right.val)
			return false;
		
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}

	private static void createTree(TreeNode currentNode, Integer[] arr, int currentIndex) {
		int leftIndex = currentIndex*2+1;
		int rightIndex = currentIndex*2+2;
		
		if(leftIndex < arr.length && arr[leftIndex] != null) {
			TreeNode leftNode = new TreeNode(arr[leftIndex]);
			currentNode.left = leftNode;
			createTree(leftNode, arr, leftIndex);
		}
		
		if(rightIndex < arr.length && arr[rightIndex] != null) {
			TreeNode rightNode = new TreeNode(arr[rightIndex]);
			currentNode.right = rightNode;
			createTree(rightNode, arr, rightIndex);
		}
	}
	
	/**
	 * traverse the tree in order and store it in the list
	 * @param node
	 * @param inorderlist
	 */
	public static void inorder(TreeNode node, List<Integer> inorderlist) {
		if(node != null) {
			inorder(node.left, inorderlist);
			inorderlist.add(node.val);
			inorder(node.right, inorderlist);
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