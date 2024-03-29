package com.pack.leet.june;
/*
Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.

Definition: In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive 
at the last level h.
*/
public class Leet_23_CountTreeNode {

	public static void main(String[] args) {

	}
	// ACCEPTED
	public int countNodes(TreeNode root) {
		if(root == null) return 0;
		return countNodes(root.left) + 1 + countNodes(root.right);
    }
}
