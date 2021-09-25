package com.pack.leet.june;
/*
 * (Accepted)
 Invert Binary tree
 
 */
public class Leet_01_InvertTree {

	public static void main(String[] args) {
		Leet_01_InvertTree obj = new Leet_01_InvertTree();
	}

	public TreeNode invertTree(TreeNode root) {
		if(root != null) {
			TreeNode temp = root.left;
			root.left = invertTree(root.right);
			root.right = invertTree(temp);
		}
		return root;
	}
}

