package com.crystalsantos.coding.binarytree;

import com.crystalsantos.coding.facebook.trees.and.graphs.TreeNode;

/**
 * Count Univalue Subtrees
 * 
 * Given the root of a binary tree, return the number of uni-value subtrees.
 * 
 * A uni-value subtree means all nodes of the subtree have the same value.
 * 
 * Example 1:
 * 
 * Input: root = [5,1,5,5,5,null,5] Output: 4 Example 2:
 * 
 * Input: root = [] Output: 0 Example 3:
 * 
 * Input: root = [5,5,5,5,5,null,5] Output: 6
 * 
 * Constraints:
 * 
 * The number of the node in the tree will be in the range [0, 1000]. -1000 <=
 * Node.val <= 1000
 */
public class CountUnivalueSubtrees {
	int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;
		isUnival(root);
		return count;
	}

	boolean isUnival(TreeNode node) {

		// base case - if the node has no children this is a univalue subtree
		if (node.left == null && node.right == null) {

			// found a univalue subtree - increment
			count++;
			return true;
		}

		boolean isUnival = true;

		// check if all of the node's children are univalue subtrees and if they have
		// the same value
		// also recursively call is_uni for children
		if (node.left != null) {
			isUnival = isUnival(node.left) && isUnival && node.left.val == node.val;
		}

		if (node.right != null) {
			isUnival = isUnival(node.right) && isUnival && node.right.val == node.val;
		}

		// return if a univalue tree exists here and increment if it does
		if (!isUnival) {
			return false;
		}

		count++;
		return true;
	}

	public static void main(String[] args) {
		CountUnivalueSubtrees unival = new CountUnivalueSubtrees();
		TreeNode root = new TreeNode(5, new TreeNode(1, new TreeNode(5), new TreeNode(5)),
				new TreeNode(5, null, new TreeNode(5)));
		System.out.println(unival.countUnivalSubtrees(root));
	}

}
