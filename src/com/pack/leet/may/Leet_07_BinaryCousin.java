package com.pack.leet.may;

// Cousins in Binary Tree
// In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

//Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

//We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

// Return true if and only if the nodes corresponding to the values x and y are cousins.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Leet_07_BinaryCousin {

	public static void main(String[] args) {
//		Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//				Output: true

//		Input: root = [1,2,3,null,4], x = 2, y = 3
//				Output: false
	}
	
	public boolean isCousins(TreeNode2 root, int x, int y) {
        int d1 = depth(root, x, 0);
        int d2 = depth(root, y, 0);
        if(d1 != d2)
            return false;
       
        TreeNode2 xP= findParent(root, x, null);
        TreeNode2 yP = findParent(root, y, null);
        if(xP.val == yP.val) return false; // sibling
        
        return true;
    }

    int height(TreeNode2 root) {
        if (root == null) return 0;
        
        int l1 = height(root.left) + 1;
        int r1 = height(root.right) + 1;
        
        return l1 > r1 ? l1 : r1;
    }
    
    int depth(TreeNode2 root, int x, int currentDepth) {
        if(root == null) return -1;
        
        if(root.val == x) return currentDepth;
        
        int depth1 = depth(root.left, x, currentDepth + 1);
        if(depth1 == -1)
            depth1 = depth(root.right, x, currentDepth + 1);
        
        return depth1;
    } 
    
    TreeNode2 findParent(TreeNode2 current, int x, TreeNode2 parent) {
        if(current == null) return null;
        
        if(current.val == x) return parent;
        
        TreeNode2 p = findParent(current.left, x, current);
        if(p == null) p = findParent(current.right, x, current);
        
        return p;
    }
}


class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2() {
	}

	TreeNode2(int val) {
		this.val = val;
	}

	TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
