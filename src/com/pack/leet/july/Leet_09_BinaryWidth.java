package com.pack.leet.july;

import java.util.LinkedList;

import com.pack.leet.june.TreeNode;

public class Leet_09_BinaryWidth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		LinkedList<TreeNode> currList = new LinkedList<>();
		currList.add(root);
		int max = 0;

		while (!currList.isEmpty()) {

			int currentLevelWidth = findWidth(currList);
			max = currentLevelWidth > max ? currentLevelWidth : max;
			LinkedList<TreeNode> nextList = new LinkedList<>();
			while (!currList.isEmpty()) {
				TreeNode node = currList.removeFirst();
				if (node != null) {
					nextList.add(node.left);
					nextList.add(node.right);
				} else {
					nextList.add(null);
					nextList.add(null);
				}
			}
			currList = nextList;
		}
		return max;
	}

	private int findWidth(LinkedList<TreeNode> currList) {
		if (currList.isEmpty())
			return 0;
		TreeNode left = currList.peekFirst();
		while (left == null && !currList.isEmpty()) {
			currList.removeFirst();
			left = currList.peekFirst();
		}

		TreeNode right = currList.peekLast();
		while (right == null && !currList.isEmpty()) {
			currList.removeLast();
			right = currList.peekLast();
		}

		return currList.size();
	}
}
