package com.pack.leet.june;
/*
Sum Root to Leaf Numbers (DFS)
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Input: [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Input: [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class Leet_26_LeafNodesSum {
	public static void main(String[] args) {
		
	}
	
	public int sumNumbers(TreeNode root) {
	    if(root == null) 
	        return 0;
	 
	    return dfs(root, 0, 0);
	}
	 
	public int dfs(TreeNode node, int num, int sum){
	    if(node == null) return sum;
	 
	    num = num*10 + node.val;
	 
	    // leaf
	    if(node.left == null && node.right == null) {
	        sum += num;
	        return sum;
	    }
	 
	    // left subtree + right subtree
	    sum = dfs(node.left, num, sum) + dfs(node.right, num, sum);
	    return sum;
	}
	
}
