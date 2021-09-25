package com.pack.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pack.leet.may.TreeNode;

import javafx.util.Pair;

public class Leet_199_03_TP {

	
	public static void main(String[] args) {
		Leet_199_03_TP obj = new Leet_199_03_TP();
		Integer[] arr = {1,2,3,4,5,6,7};
		TreeNode root = obj.createBST(arr);
	}


	 private com.pack.contest.TreeNode createBST(Integer[] arr) {
		return null;
	}


	public int countPairs(TreeNode root, int distance) {
		 int count = 0;
		 Map<TreeNode, Integer> leafDistanceFromRoot = new HashMap<>();
		 preorder(root, leafDistanceFromRoot, 1);
		 
		 return count;
	 }
	 
	 public void preorder(TreeNode root, Map<TreeNode, Integer> map, int distance) {
		 if(root == null)
			 return;
		 
		 if(root.left == null && root.right == null) {
			 map.put(root, distance);
		 }
		 
		 preorder(root.left, map, distance+1);
		 preorder(root.right, map, distance+1);
	 }
	 
	 
	

}
